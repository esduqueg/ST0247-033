import javafx.util.Pair;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[]args){

        Graph g = new Graph();
        Backtraking bt = new Backtraking();
        Stack<Pair<Double,Points>> road;
        Scanner sca = new Scanner(System.in);
        System.out.println("Please enter the path of the file to create the graph: \n"+
                "\t\t Remember that it's format must be:  \n" +
                "for Vertex(Nodes): ID, X coordinate, Y coordinate, name.\n" +
                "for Arcs(connections): ID1, ID2, distance, name.\n" +
                "\t\tThis is extremely important, make sure the format is correct, otherwise the program won't work correctly\n\n" +
                "Now enter the path:\n");
        String path = sca.nextLine();
        g.createFromFile(path);
        System.out.println("Enter the id of the starting node: \n");
        long id1 = sca.nextLong();
        System.out.println("Enter the id of the ending node: \n");
        long id2 = sca.nextLong();
        road = bt.shortestPath(g,id1,id2);
        System.out.println("The shortest path is going throw: ");
        int cost = 0;
        for(Pair<Double,Points> p: road){
            cost+=p.getKey();
            System.out.println(p.getValue().getId()+" "+p.getValue().getName());
        }
        System.out.println("And its total cost is: \n"+
                cost);

    }
}
