import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public class RoutePrinter {

    private LinkedList<Pair<LinkedList<Vertex>, Double>> l;

    public RoutePrinter(LinkedList<Pair<LinkedList<Vertex>, Double>> l, String file_path, int U, double p, long creationTime, long analisisTime){

        this.l = l;

        fileWriter(file_path,U,p,creationTime,analisisTime);

    }

    private void fileWriter(String file_path, int U, double p, long creationTime, long analisisTime){

        long printingTime = System.currentTimeMillis();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("RoutesFor"+U+"p"+p+"ForAll.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        writer.println("This are the routes for the employees whos houses are in the "+file_path+"\n\n" +
                "\nTotal Cars  "+l.size()+
                "\nCars Reduced: "+(l.size()*100/U)+"%"+
                "\nReading Time: "+creationTime+"ms"+
                "\nFinding Routes Time: "+analisisTime+"ms"
        );

        for(int i = 0; i<l.size();i++){

            writer.println("ROUTE #"+(i+1)+"\n\n");

            int size = l.get(i).getKey().size();
            for(int j = 0; j<size;j++){

                if(j+1 == size){
                    writer.print(1+" Universidad EAFIT ");
                    writer.println("\t\tTotal Route Cost = "+l.get(i).getValue()+"\n" +
                            "------------------------------------------------------------------------------------------------------------------" +
                            "------------\n");
                }else {
                    writer.print(l.get(i).getKey().get(j).getNum()+" ("+l.get(i).getKey().get(j).getName()+")"
                            + "  ->  ");
                }



            }

        }
        writer.close();
        printingTime = System.currentTimeMillis()-printingTime;
        System.out.println(printingTime);
    }

}
