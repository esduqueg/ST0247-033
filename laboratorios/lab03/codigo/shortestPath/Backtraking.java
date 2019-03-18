import javafx.util.Pair;
import java.util.Stack;

public class Backtraking {

    private Stack<Pair<Double,Points>> path;
    private Graph g;

    public Backtraking(){
        path = new Stack<>();
    }

    public Stack<Pair<Double,Points>>shortestPath(Graph g, long originId, long endId){

        this.g = g;
        Stack<Pair<Double,Points>> aux = new Stack<Pair<Double,Points>>();
        Points origin = g.nodeList.get(originId);
        aux.push(new Pair<Double, Points>(0.0,origin));
        getPath(origin , g.nodeList.get(endId), aux);
        return path;
    }

    private boolean getPath(Points origin, Points end, Stack<Pair<Double,Points>> aux){

        if(origin.getId() == end.getId()){
            compare(aux);
            return true;
        }else{
            origin.Visited();
            for(int i = 0; i<origin.arcs.size(); i++){
                Points neighbor = origin.arcs.get(i).getValue();
                if(!neighbor.isVisited()){
                    aux.push(origin.arcs.get(i));
                    getPath(neighbor,end,aux);
                }
            }
            origin.Unvisited();
            aux.pop();
            return true;
        }

    }

    private void compare(Stack<Pair<Double,Points>> aux){

        if(path.isEmpty()){
            path = aux;
        }else{
            double pathCost = 0;
            double auxCost = 0;
            for(int i =0; i<path.size(); i++){
                 pathCost += path.get(i).getKey();
            }

            for (int i = 0; i<aux.size(); i++){
                auxCost += aux.get(i).getKey();
            }

            if(pathCost>auxCost){
                path = aux;
            }
        }

    }

}
