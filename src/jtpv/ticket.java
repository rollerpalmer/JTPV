/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtpv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc1
 */
public class ticket {
    int mesa;
    char estado;
    double precio;
    String nombre;
    ResultSet rs;
    conexion_sqlite conexion;
    public ticket(int mesa){
        this.estado='a';
        this.mesa=mesa;
        this.precio=0.0;
        this.nombre="plato";
        this.conexion = new conexion_sqlite();
        rs = null;
    }
    public void acceso(String plato){
        //Acceso a BBDD para obtener el nombre del plato
        rs=conexion.consulta("select * from PRODUCTOS WHERE N_PRODUCTO="+plato);
    }
    public String get_nombre(){       
        try {
            nombre=rs.getString("NOMBRE");
        } catch (SQLException ex) {
            Logger.getLogger(ticket.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return nombre;
        }
                        
    }
    public Double get_precio(){
        try {            
            precio=rs.getDouble("PRECIO");
        } catch (SQLException ex) {
            Logger.getLogger(ticket.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return precio;
        }
        
    }
    public int get_mesa(){
        return this.mesa;
    }
    public char get_estado(){
        return estado;
    }
    public void cerrar_ticket(){
        estado = 'c';
    }
}
