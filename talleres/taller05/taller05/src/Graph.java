import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;

public class Graph {

    Map<Long,Points> nodeList;

    public  Graph(){

        nodeList = new HashMap<Long,Points>();

    }

    private void ReadFile(String path){

        boolean inVer = false;
        double x,y;
        String name = "";
        System.out.println(path);

        try{

            Scanner sca = new Scanner(new File(path));


            String splitted[];
            String data;

            while(sca.hasNextLine()){

                data = sca.nextLine();
                splitted = data.split(" ");

                /*
                if(splitted.length==0){
                    data = sca.nextLine();
                    splitted = data.split(" ");
                    Scanner pr = new Scanner(System.in);
                    int a = pr.nextInt();
                }
                */

                if(splitted[0].contains("Vertices")){

                    inVer = true;
                    data = sca.nextLine();

                }else if(splitted[0].equals("Arcos.")) {

                    inVer = false;
                    data = sca.nextLine();
                    System.out.println(true);

                }

                if (inVer){

                    splitted = data.split(" ");
                    long id = Long.parseLong(splitted[0]);
                    y = Double.parseDouble(splitted[1]);
                    x = Double.parseDouble(splitted[2]);


                    if(splitted.length>3){

                        if(splitted.length==5){

                            name = splitted[3]+" "+splitted[4];

                        }else{

                            name = splitted[3];

                        }

                    }

                    nodeList.put(id , new Points(id, name, x, y ));
                    //System.out.println(dic.get(id).getId());


                }else{

                    try {


                        splitted = data.split(" ");

                        if(splitted.length>=3) {
                            long origin = Long.parseLong(splitted[0]);
                            long end = Long.parseLong(splitted[1]);
                            double distance = Double.parseDouble(splitted[2]);

                            if (nodeList.containsKey(origin)) {

                                nodeList.get(origin).addPoint(distance, nodeList.get(end));
                                nodeList.get(end).addPoint(distance, nodeList.get(origin));

                            }
                        }else{
                            System.out.println("Without distance");
                        }
                    }catch (NoSuchElementException e){

                        System.out.println("NotFinded");

                    }


                }

            }

            sca.close();


        }catch (FileNotFoundException ex){

            ex.printStackTrace();

        }

    }

    public void createGraph(){

        Scanner sca = new Scanner(System.in);

        createNodes(sca);
        createArcs(sca);

    }

    private void createNodes(Scanner sca){

        long id1;
        System.out.println("\t\t\tCreate the nodes you want in your graph");

        while(true){

            System.out.println("\nIf you are done creating nodes, enter a num smaller than 1.\n");
            System.out.println("Advice: the nodes id must be 1 dor the firdt node, 2 for the second ... and so on!! ");
            System.out.println("Enter the id of the node:");
            id1 = sca.nextLong();

            if(id1<1){
                break;
            }else {
                nodeList.put(id1, new Points(id1));
            }

        }

    }

    private void  createArcs(Scanner sca){

        long id1,id2;
        double distance;
        System.out.println("\t\t\tNow create the connections that your graph will have.");

        while(true) {

            System.out.println("\nNote: Enter a number less tha 1 to finish." +
                    "\nEnter the id of the start node: ");
            id1 = sca.nextLong();

            if(id1<1){

                break;

            } else if (nodeList.containsKey(id1)) {

                System.out.println("\nEnter the id of the end node: ");
                id2 = sca.nextLong();

                if(nodeList.containsKey(id2)) {

                    System.out.println("\nEnter the distance between the nodes: ");
                    distance = sca.nextDouble();
                    nodeList.get(id1).addPoint(distance, nodeList.get(id2));
                    nodeList.get(id2).addPoint(distance, nodeList.get(id1));

                }else{
                    System.out.println("Node 2 doesn´t exist");
                }

            }else{
                System.out.println("Node 1 doesn´t exist");
            }

        }


    }
}
