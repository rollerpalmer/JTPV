/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtpv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc1
 */
public class conexion_sqlite {
    Connection connection = null;
    Statement statement;
    public conexion_sqlite(){
        try {
            // create a database connection
            this.connection = DriverManager.getConnection("jdbc:sqlite:chinatown.db");
            this.statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
        } catch (SQLException ex) {
            Logger.getLogger(conexion_sqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet consulta(String sql){
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(conexion_sqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void insercion(String sql){
        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(conexion_sqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrar_conexion(){
        try
      {
        if(connection != null){
          connection.close();}
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
}
