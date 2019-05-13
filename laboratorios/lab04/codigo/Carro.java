/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.datos.y.algoritmos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author duque
 */
public class Carro {
    
    public static int carro;
    HashMap<Integer,Integer> cupos = new HashMap<Integer,Integer>();
    
    public void Carro(int c,HashMap<Integer,Integer> x)
    {
        this.carro=c;
        this.cupos=x;
    }
    
    public int getCarro()
    {
        return carro;
    }
    
    public void setCarro(int carro)
    {
        this.carro=carro;
    }
    
    public HashMap<Integer,Integer> getCupo()
    {
        return cupos;
    }
   
    public void setCupo(HashMap<Integer,Integer> x)
    {
        this.cupos=x;
    }
    
}
