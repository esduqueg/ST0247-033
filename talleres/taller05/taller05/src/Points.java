import javafx.util.Pair;
import java.util.LinkedList;

public class Points {

    private long id;
    private String name;
    private double x, y;
    private boolean visitState = false;
    private String color;
    LinkedList<Pair<Double,Points>> arcs;

    public Points(long id,String name, double x, double y){

        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
        arcs = new LinkedList<Pair<Double,Points>>();

    }


    public Points(long id){

        this.id = id;
        arcs = new LinkedList<Pair<Double,Points>>();

    }

    public void addPoint(Double distance, Points p){

        Pair<Double,Points> pair = new Pair(distance,p);
        arcs.add(pair);

    }

    public void printArcs(){

        for (int i = 0; i< arcs.size(); i++){

            System.out.println("   Connections of "+id+" with name "+name+", with coordinates: x: "+x+", y: "+y+"\n");
            System.out.println("Node:      "+arcs.get(i).getValue().getId()+
                    "\nname:      "+arcs.get(i).getValue().getName()+
                    "\nDistance:      "+arcs.get(i).getKey());

        }

    }

    public void searchNode(long id){

        boolean isContained = false;

        for(int i = 0; i < arcs.size(); i++){

            if(arcs.get(i).getValue().getId()==id){

                isContained = true;
                System.out.println("The distance between node "+this.id+" and node "+id+" is: \t"+arcs.get(i).getKey());

            }

        }

        if(!isContained){

            System.out.println("There is no connection between this nodes");

        }

    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public boolean isVisited(){
        return visitState;
    }

    public void Visited(){
        visitState = true;
    }

    public void Unvisited(){
        visitState = false;
    }

    public long getId(){

        return id;

    }

    public String getName(){
        return name;
    }

    public double getX(){

        return x;

    }

    public double getY(){

        return y;

    }

}
