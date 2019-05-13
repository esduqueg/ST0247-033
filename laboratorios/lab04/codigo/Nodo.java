/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.datos.y.algoritmos;
import java.util.HashMap;
/**
 *
 * @author duque
 */
public class Nodo {
    
    public String XNodo;
    boolean cupo;
   
    public Nodo(String xNodo)
    {
       this.XNodo = xNodo;
       this.cupo = false;
       
    }    
    
    public String getNodo()
    {
        return XNodo;
    }
    
    public void setNodo(String Nodo)
    {
        this.XNodo=Nodo;
    }
    
    public boolean getCupo()
    {
        return cupo;
    }
   
    public void setCupo(boolean x)
    {
        this.cupo=x;
    }
    
    
}