/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jtpv;

import javax.swing.JInternalFrame;

/**
 *
 * @author pc1
 */
public class gestion_ventanas {
    public internal_frame_mesas m;
    
    public gestion_ventanas(){
        m = new internal_frame_mesas();
    }
    public void abrir_vmesas(){
         
        //jDesktopPane1.add(m);
        m.setVisible(true);
    }
    public void cerrar_vmesas(){
        m.setVisible(false);
    }
    public JInternalFrame get_internalframe(){
        return m;
    }
}
