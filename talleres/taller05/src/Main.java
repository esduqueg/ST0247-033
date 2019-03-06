public class Main {

    public static  void main(String[] args){

        Graph g = new Graph();
        g.createGraph();
        DaVinci dv = new DaVinci(g);
        dv.Draw(4);

        for(long i = 1; i<=g.nodeList.size();i++){
            String color = g.nodeList.get(i).getColor();
            System.out.println(color);
        }


    }

}
