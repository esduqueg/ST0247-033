

public class Vertex implements Comparable <Vertex> {

    private String name;
    private double x,y,costToTarget;
    private int number;
    private boolean isGoing = false;

    public Vertex(int number, double x, double y, String name){
        this.number = number;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public boolean equals (Vertex other){

        return (number == other.getNum());

    }

    @Override
    public int compareTo(Vertex other) {

        if(this.equals(other))
            return 0;
        else if(costToTarget < other.getCostToTarget())
            return 1;
        else
            return -1;
    }

    public double getCostToTarget(){ return costToTarget;}

    public void setCostToTarget(double cost){ costToTarget = cost;}

    public boolean inCar(){ return isGoing;}

    public void pickedUp(){ isGoing = true;}

    public double getX(){ return x; }

    public double getY(){ return y; }

    public int getNum(){ return number; }

    public String getName(){return name;}

}
