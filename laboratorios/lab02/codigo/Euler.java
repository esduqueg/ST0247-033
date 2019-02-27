/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author duque
 */
public class Euler {
    static int n;
    static int a;
    static int [][] Grafo;
    
    public static void CrearGrafo()
    {
        Scanner lector=new Scanner(System.in);
        System.out.println("BIENVENIDO AL CREADOR DE MEJOR RUTA");
        System.out.println("");
        System.out.println("Ingrese la cantidad de puntos que tiene la ruta");
        n=lector.nextInt();
        System.out.println("");
        System.out.println("Ingrese la cantidad de caminos que hay entre todos los puntos");
        a=lector.nextInt();
        Grafo=new int[n+1][n+1];
        System.out.println("");
        System.out.println("AHORA VAMOS A LLENAR EL GRAFO:   ");
        System.out.println("");
        
        for(int i=1;i<n;i++)
        {
            for(int j=2;j<=n;j++)
            {
                
                System.out.println("Ingrese la distancia entre el punto: "+i+" y "+j);
                System.out.println("¡ Si no hay distancia,ingrese 0 !");
                int x=lector.nextInt();
                Grafo[i][j]=x;
            }
        }
        
        Euleriano();
    }
    
    public static void Euleriano()
    {
        
        int cont=0;
        int j=1;
         ArrayList<Integer> camino=new ArrayList<Integer>();
        
        for(int i=1;i<n;i++)
        {
            if(Grafo[i][j+1] < Grafo[i][j+2] && Grafo[i][j+2]<Grafo[i][j+3] && Grafo[i][j+1] !=0 && Grafo[i][j+2] !=0 && Grafo[i][j+3] !=0 )
            {
                camino.add(i);
                camino.add(j+1);
                cont=cont+Grafo[i][j+1];
            }
            else if(Grafo[i][j+2] < Grafo[i][j+3] && Grafo[i][j+3]<Grafo[i][j+1] && Grafo[i][j+1] !=0 && Grafo[i][j+2] !=0 && Grafo[i][j+3] !=0)
            {
                camino.add(i);
                camino.add(j+2);
                cont=cont+Grafo[i][j+2];
            }
            else if(Grafo[i][j+3] < Grafo[i][j+1] && Grafo[i][j+1]<Grafo[i][j+2] && Grafo[i][j+1] !=0 && Grafo[i][j+2] !=0 && Grafo[i][j+3] !=0)
            {
                camino.add(i);
                camino.add(j+3);
                cont=cont+Grafo[i][j+3];
            }
            
            
        }
        
        System.out.println("EL CAMINO MAS EFICIENTE PARA REALIZAR TODO EL RECORRIDO ES: ");
        System.out.println("");
        
            System.out.print(camino);

    }
    
    
    
    
}
