import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class DataObtainer {

    public DataObtainer(){


    }

    /**
     * This method takes the file path string an uses it to read the file, from which it set ups
     * all the needed that structures to solve this problem
     *
     * @param file_path
     * @return ?
     */

    public void Read(String file_path){

        String name,line;     // variables that will store the name of each vertex and the linea that its being readed.
        String splitted [];
        int num1,num2;        //numbers of the nodes that will set the edges in the graph
        double x,y;        // x and y coordinates of each vertex
        double distance;       //Respective distance between two nodes
        boolean inVertex = false;
        boolean inEdges = false;
        double p = getP(file_path);         //P given in the file_path string
        int numNodes = getNumNodes(file_path);       //Number of nodes given in the file path string

        Map<Integer, Vertex> nodes = new HashMap<>(numNodes);       //HashMap which will store every single vertex
        Map<Integer,PriorityQueue<Edges>> matrix = setUpMatrix(numNodes);        //HashMap that represents the graph
        PriorityQueue<Vertex> startingCars = new PriorityQueue<>(numNodes);        //PriorityQueue that contains the vertex from furthest to closest.

        long creationTime = System.currentTimeMillis();
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file_path));
            while ((line = reader.readLine())!=null){

                splitted = line.split(" ");

                if(splitted[0].toLowerCase().equals("vertices.")){

                    splitted = reader.readLine().split(" ");
                    inVertex = true;

                }else if(splitted[0].equals("Costo")){

                    splitted = reader.readLine().split(" ");
                    inEdges = true;
                    inVertex = false;

                }


                if(inVertex && (splitted.length>=3)){

                    num1 = Integer.parseInt(splitted[0]);
                    x = Double.parseDouble(splitted[1]);
                    y = Double.parseDouble(splitted[2]);
                    name = getName(splitted);
                    nodes.put(num1, new Vertex(num1,x,y,name));


                }else if(inEdges && splitted.length==3){

                    num1 = Integer.parseInt(splitted[0]);
                    num2 = Integer.parseInt(splitted[1]);
                    distance = Integer.parseInt(splitted[2]);
                    Edges edge = new Edges(nodes.get(num2),distance);

                    if(num1 == 1){
                        nodes.get(num2).setCostToTarget(distance);
                        startingCars.add(nodes.get(num2));
                        matrix.get(1).add(edge);

                    }else{

                        matrix.get(num1).add(edge);

                    }


                }

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        creationTime = System.currentTimeMillis()-creationTime;


        /*
        System.out.println(nodes.size());
        System.out.println();
        System.out.println(nodes);
        System.out.println();

        //System.out.println(startingCars.poll().getNum());

        //System.out.println();



        for(int i = 1; i<=matrix.size();++i) {
            System.out.println();

            while(!matrix.get(i).isEmpty()){
                Edges v = matrix.get(i).poll();
                System.out.print(v.getEndNode().getNum()+"-"+v.getHeu()+"-"+v.getCost()+"  ");
                //System.out.println(startingCars.poll().getNum());
            }
        }

        */


        driveManager dM = new driveManager(startingCars,matrix,nodes,p);

        long analisisTime = System.currentTimeMillis();
        LinkedList<Pair<LinkedList<Vertex>, Double>> l = dM.getRides();
        analisisTime = System.currentTimeMillis()-analisisTime;
        RoutePrinter rt = new RoutePrinter(l,file_path,numNodes,p,creationTime,analisisTime);
        //System.out.println("Milliseconds: "+(System.currentTimeMillis()-startime));
        //System.out.println(l.size());


        /*
        for(int i = 0; i<l.size();i++){

            System.out.println();

            int size = l.get(i).getKey().size();
            for(int j = 0; j<size;j++){

                System.out.print(l.get(i).getKey().get(j).getNum()
                        +" - ");

                if(j+1 == size){
                    System.out.println(l.get(i).getValue());
                }

            }


        }
        */






    }

    private String getName(String splitted[]){

        String name = "";

        for(int i = 3; i<splitted.length;++i){
            name = splitted[i]+" ";
        }

        return name;


    }

    private HashMap<Integer,PriorityQueue<Edges>> setUpMatrix(int nodes){

        HashMap<Integer, PriorityQueue<Edges>> matrix = new HashMap<>(nodes);

        for(int i = 1; i<=nodes;i++){
            matrix.put(i,new PriorityQueue<Edges>(nodes));
        }

        return matrix;

    }

    private int getNumNodes(String path){

        String[] splitted = path.split("-");
        return Integer.parseInt(splitted[2].substring(splitted[2].indexOf("U=")+2));

    }

    private double getP(String path){

        return    Double.parseDouble(path.substring(path.indexOf("p=")+2,path.indexOf(".txt")));

    }

}
