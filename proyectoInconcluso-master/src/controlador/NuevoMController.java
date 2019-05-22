/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import modelo.Mensaje;
import modelo.MensajeDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.BandejaEntrada;
import vista.Login;
import vista.NuevoMensaje;




/**
 *
 * @author Antonia
 */
public class NuevoMController implements ActionListener {
    
    private NuevoMensaje nm;
    private javax.swing.JComboBox<String> destinatarioCB;
    private UsuarioDAO uDao = new UsuarioDAO(); 
    private MensajeDAO mensajeDao =  new MensajeDAO(); 
    
     ArrayList<Usuario> usuarios = new ArrayList<>(); 
    

    public NuevoMController(NuevoMensaje nm, JComboBox<String> destinatarioCB) {
        this.nm = nm;
        this.destinatarioCB = destinatarioCB;
        
        System.out.println("bueno");
        
        usuarios = uDao.getUsuarios(); 
        
        System.out.println("bueno");
        
        String v1 = usuarios.get(0).getNombre()+" "+usuarios.get(0).getId_usuario(); 
        String v2 = usuarios.get(1).getNombre()+" "+usuarios.get(1).getId_usuario(); 
         
        destinatarioCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { v1, v2}));
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         int idUsuario = usuarios.get(nm.getDestinatarioCB().getItemCount()-1).getId_usuario(); 
        
        Usuario usuarioE = usuarios.get(nm.getDestinatarioCB().getItemCount()-1);
        Usuario usuarioR = usuarios.get(nm.getDestinatarioCB().getItemCount() -2);
         String contenido = nm.getCuerpoMensajeTA().getText(); 
         
         Mensaje mensaje = new Mensaje(jsfsjk, usuarioE, usuarioR, contenido);
            
               
              
        
    }
    
  
  
}
