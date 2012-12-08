/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtpv;

import java.util.*;

/**
 *
 * @author pc1
 */
public class lista_mesas {
    List lmesas;
    public lista_mesas(){
        lmesas = new ArrayList();
        
    }
    public void aniadir_mesa(int m){
        
        if (get_mesa(m)){
            ticket t = new ticket(m);
            lmesas.add(t);
        }else{
            //leer del arraylist la mesa anteriormente
        }                
    }
    public void eliminar_mesa(){        
             
    }
    public String producto_n(String p, int m){       
        ticket t = get_mesa(m);
        if(t!=null){
            t.acceso(p);
            return t.get_nombre();
        }
        return "plato";
    }
    public Double producto_p(String p, int m){       
        ticket t = get_mesa(m);
        if(t!=null){
            t.acceso(p);
            return t.get_precio();
        }
        return 0.0;
    }
    public boolean existe_ticket(String plato){
        int p;
        p = Integer.parseInt(plato);
        if (lmesas.get(p)!=null){
            return true;
        }
        return false;
    }
    public ticket get_mesa(int indice){
        Iterator iterador = lmesas.iterator();
        ticket t;
        while(iterador.hasNext()){
            t = (ticket) iterador.next();
            if(t.get_mesa()==indice){
                return t;
            }
        }
        return null;
    }
}
