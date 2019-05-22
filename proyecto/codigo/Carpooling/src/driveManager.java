import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class driveManager {

    private PriorityQueue<Vertex> startingCars;
    private Map<Integer,PriorityQueue<Edges>> matrix;
    private Map<Integer,Vertex> nodes;
    private double p;
    private int min;

    public driveManager(PriorityQueue<Vertex> startingCars, Map<Integer,PriorityQueue<Edges>> matrix, Map<Integer,Vertex> nodes, double p){

        this.startingCars = startingCars;
        this.matrix = matrix;
        this.nodes = nodes;
        this.p = p;

    }

    /*
    public driveManager(PriorityQueue<Vertex> startingCars, Map<Integer,PriorityQueue<Edges>> matrix, Map<Integer,Vertex> nodes, int min){

        this.startingCars = startingCars;
        this.matrix = matrix;
        this.nodes = nodes;
        this.min = min;

    }
    */


    public LinkedList<Pair<LinkedList<Vertex>, Double>> getRides(){

        LinkedList<Pair<LinkedList<Vertex>, Double>> ridesList = new LinkedList<>();
        LinkedList<Vertex> ride;
        int id;
        double maxTime;
        double costSum;
        int cont;
        boolean validRide,isEqual, hasCar;
        Vertex carOwner;

        //long startime = System.currentTimeMillis();
        while(!startingCars.isEmpty()){

            carOwner = startingCars.poll();
            id = carOwner.getNum();
            hasCar = nodes.get(id).inCar();

            if(!hasCar && id!= 1){

                ride = new LinkedList<>();
                ride.add(nodes.get(id));
                nodes.get(id).pickedUp();

                //maxTime = nodes.get(id).getCostToTarget()*p;
                //System.out.println(maxTime);
                costSum = 0;
                cont = 1;

                while(cont<5 && !matrix.get(id).isEmpty()){

                    Edges other = matrix.get(id).poll();
                    isEqual = nodes.get(id).equals(other.getEndNode());
                    hasCar =  nodes.get(other.getEndNode().getNum()).inCar();

                    if(!isEqual && other.getEndNode().getNum()!=1 && !hasCar && id!=1){

                        maxTime = nodes.get(id).getCostToTarget()*p;
                        validRide = maxTime >= (costSum + other.getHeu());

                        if(validRide) {


                            //System.out.println(id+"  to  "+other.getEndNode().getNum());
                            ride.add(other.getEndNode());
                            nodes.get(other.getEndNode().getNum()).pickedUp();
                            costSum += other.getCost();
                            //System.out.print("       "+costSum+"\n");
                            cont++;
                            id = other.getEndNode().getNum();



                        }else{

                            //System.out.println(id+"  to  "+other.getEndNode().getNum() +"   (Invalid)");
                            //System.out.println("Invalid");
                            ride.add(nodes.get(1));

                            break;

                        }
                    }

                }

                costSum+=nodes.get(id).getCostToTarget();
                ridesList.add(new Pair(ride,costSum));

            }

        }

        //System.out.println("Milliseconds: "+(System.currentTimeMillis()-startime));

        return ridesList;

    }

}
