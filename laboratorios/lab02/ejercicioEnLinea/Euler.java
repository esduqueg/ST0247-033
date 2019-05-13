paquete  laboratorio2 ;
import  java.util.Scanner ;
import  java.util.ArrayList ;

/ **
 *
* @Author Duque
 * /
 clase  p�blica Euler {
    est�tica  int n;
    est�tica  int a;
    static  int [] [] Grafo ;
    
     vac�o est�tico  p�blico CrearGrafo () 
    {
        Lector del esc�ner = nuevo  esc�ner ( System . In);
        Sistema . a cabo . println ( " BIENVENIDO AL CREADOR DE MEJOR RUTA " );
        Sistema . a cabo . println ( " " );
        Sistema . a cabo . println ( " Ingrese la cantidad de puntos que tiene la ruta " );
        n = lector . nextInt ();
        Sistema . a cabo . println ( " " );
        Sistema . a cabo . Imprimir ( " Ingrese la cantidad de caminos que hay entre todos los puntos " );
        a = lector . nextInt ();
        Grafo = nuevo  int [n + 1 ] [n + 1 ];
        Sistema . a cabo . println ( " " );
        Sistema . a cabo . println ( " AHORA VAMOS A LLENAR EL GRAFO:    " );
        Sistema . a cabo . println ( " " );
        
        para ( int i = 1 ; i < n; i ++ )
        {
            para ( int j = 2 ; j <= n; j ++ )
            {
                
                Sistema . a cabo . println ( " Ingrese la distancia entre el punto: " + i + " y " + j);
                Sistema . a cabo . println ( " �Si no hay distancia, ingrese 0! " );
                int x = lector . nextInt ();
                Grafo [i] [j] = x;
            }
        }
        
        Euleriano ();
    }
    
     vac�o est�tico  p�blico Euleriano () 
    {
        
        int cont = 0 ;
        int j = 1 ;
         ArrayList < Integer > camino = new  ArrayList < Integer > ();
        
        para ( int i = 1 ; i < n; i ++ )
        {
            si ( Grafo [i] [j + 1 ] <  Grafo [i] [j + 2 ] &&  Grafo [i] [j + 2 ] < Grafo [i] [j + 3 ] &&  Grafo [i] [j + 1 ] ! = 0  &&  Grafo [i] [j + 2 ] ! = 0  &&  Grafo [i] [j + 3 ] ! = 0 )
            {
                Camino . a�adir (i);
                Camino . a�adir (j + 1 );
                cont = cont + Grafo [i] [j + 1 ];
            }
            m�s  si ( Grafo [i] [j + 2 ] <  Grafo [i] [j + 3 ] &&  Grafo [i] [j + 3 ] < Grafo [i] [j + 1 ] &&  Grafo [i] [j + 1 ] ! = 0  &&  Grafo [i] [j + 2 ] ! = 0  &&  Grafo [i] [j + 3 ] ! = 0 )
            {
                Camino . a�adir (i);
                Camino . a�adir (j + 2 );
                cont = cont + Grafo [i] [j + 2 ];
            }
            m�s  si ( Grafo [i] [j + 3 ] <  Grafo [i] [j + 1 ] &&  Grafo [i] [j + 1 ] < Grafo [i] [j + 2 ] &&  Grafo [i] [j + 1 ] ! = 0  &&  Grafo [i] [j + 2 ] ! = 0  &&  Grafo [i] [j + 3 ] ! = 0 )
            {
                Camino . a�adir (i);
                Camino . a�adir (j + 3 );
                cont = cont + Grafo [i] [j + 3 ];
            }
            
            
        }
        
        Sistema . a cabo . println ( " EL CAMINO MAS EFICIENTE PARA REALIZAR TODO EL RECORRIDO ES: " );
        Sistema . a cabo . println ( " " );
        
            Sistema . a cabo . imprimir (camino);

    }
    
    
    
    
}