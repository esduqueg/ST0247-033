
public class Edges implements Comparable <Edges>{

    private Vertex endNode;
    private double cost;
    private double heuristic;

    public Edges (Vertex endNode, double cost){

        this.endNode = endNode;
        this.cost = cost;
        heuristic = cost+endNode.getCostToTarget();

    }

    public boolean equals (Edges other){

        return (endNode.getNum() == other.getEndNode().getNum());

    }

    @Override
    public int compareTo(Edges other) {

        if(this.equals(other))
            return 0;
        else if(heuristic > other.getHeu())
            return 1;
        else
            return -1;
    }

    public double getCost(){return cost;}

    public double getHeu(){return heuristic;}

    public Vertex getEndNode(){return endNode;}
}
