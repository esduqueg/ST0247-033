/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkg4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author duque
 */
public class Lector {
    
        public static String linea;
        public static int N,costo;
        public static String Origen, Llegada, Costo;
        public static int D,R;
        public static ArrayList<Integer> costos=new ArrayList<Integer>();
    public static void Leer()
    {
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C://Users//duque//Documents//EAFIT//3 SEMESTRE//BASE DE DATOS Y ALGORITMOS II//Lab4.txt"));
            while ((linea = reader.readLine()) != null) {
                String [] Renglon = linea.split(" ");

                if (Renglon.length == 3 && Renglon[0]=="0" && Renglon[1]=="0" && Renglon[0]=="0") 
                {
                  
                    JOptionPane.showMessageDialog(null,"YA TERMINÓ");
                
                }
                
                if(Renglon.length==3)
                {
                    
                    N=Integer.parseInt(Renglon[0]);
                    D=Integer.parseInt(Renglon[1]);
                    R=Integer.parseInt(Renglon[2]);
                }
                if(Renglon.length==N)
                {
                    costo=0;
                    for(int i=0;i<=N;i++)
                    {
                        int x=Integer.parseInt(Renglon[i]);
                        costo=costo+x;
                        costos.add(costo);
                    }
                }
                
                    System.out.println("N: "+N);
                    System.out.println("D: "+D);
                    System.out.println("R: "+R);
                }
            Analisar();           
            reader.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"MARICA NO LO PUDE HACER");
            
        }
    }
    
    public static void Analisar()
    {
        for(int i=0;i<N;i++)
        {
            if(i%2==2)
            {
                
            }
            
            if(i%2==1)
            {
                
            }
        }
    }
}
