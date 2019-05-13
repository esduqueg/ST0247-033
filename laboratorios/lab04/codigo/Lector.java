/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.datos.y.algoritmos;

/**
 *
 * @author duque
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Lector {

    static int[][] Aristas = new int[206][206];
    static HashMap<String, Object> Nodos = new HashMap<String, Object>();
    static HashMap<Integer, Integer> cupo = new HashMap<Integer, Integer>();
    public static int contador = 0;
    public static ArrayList<Integer> cupos = new ArrayList<Integer>();
    public static ArrayList<Integer> N=new ArrayList<Integer>();
    public static int i;
    public static Nodo n;
    public static Carro c;
//GrafoY.put(XNodo,Y);

    public static void Lector() {
        String linea;
        String Nodo;
        String Origen, Llegada, Costo;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C://Users//duque//Documents//EAFIT//3 SEMESTRE//BASE DE DATOS Y ALGORITMOS II//205Coordenadas.txt"));
            while ((linea = reader.readLine()) != null) {
                String[] Renglon = linea.split(" ");

                if (Renglon.length == 4) {

                    Nodo = Renglon[0];
                    n = new Nodo(Nodo);
                    Nodos.put(Nodo, n);
                    //System.out.println("Cupo: "+Nodos.getOrDefault(1,n.cupo)+"  Nodo: "+Nodos.getOrDefault(1,n.XNodo));

                }

                if (Renglon.length == 3) {
                    Origen = Renglon[0];
                    Llegada = Renglon[1];
                    Costo = Renglon[2];
                    CrearMatris(Origen, Llegada, Costo);
                }

            }

            reader.close();
            Recorrer();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"MARICA NO LO PUDE HACER");
            
        }
    }

    public static void CrearMatris(String origen, String llegada, String costo) {
        int ori = Integer.parseInt(origen);
        int lle = Integer.parseInt(llegada);
        int cos = Integer.parseInt(costo);
        Aristas[ori][lle] = cos;
    }

    public static void Recorrer() {
        for (i = 1; i <= Aristas.length; i++) {
            jota();
            Getiar();
            contador = contador + 1;
            c = new Carro();
            c.setCarro(contador);
            c.setCupo(cupo);
        }
        cupo.clear();
        N.clear();
        


        //System.out.println("Carros" + contador);
         
    }

    public static void jota() {
        for (int j = 1; j < Aristas.length; j++) {
            Object x = Nodos.getOrDefault(i, n.cupo);
            if (x.equals(false)) {
                Object y = Nodos.getOrDefault(j, n.cupo);
                if (x.equals(false)) {

                    Menores(i, j, x, y);

                }

            }

        }

    }

    public static void Menores(int i, int j, Object x, Object y) {

        if (cupo.size() < 5) {

            cupo.put(j, Aristas[i][j]);
            N.add(j);
        } else {
            for (int s = 0; s <= cupo.size(); s++) {
                /* if (Aristas[i][j] < cupo.get(s)) {
                    cupo.remove(s);
                    cupo.put(s, Aristas[i][j]);
                    N.remove(s);
                    N.add(j);
                    jota();
                  

                }
*/ System.out.println(Aristas[i][j]);
                System.out.println(cupo.get(s));
            }

        }

    }

    public static void Getiar() {
        for (int i = 1; i < N.size(); i++) {
            String value = Integer.toString(N.get(i));
            Nodos.replace(value, n.cupo = true);
         
        
        }

    }
}


// Mañana tengo que volver cupos un hash map.
//ademas adaptar todos los procesos que tengo a hashmap.
//revisar el for que recorre a cupos.

