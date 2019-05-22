/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import java.util.ArrayList;
/**
 *
 * @author Antonia
 */
public class MensajeDAO {
    
 Conexion con;
    private UsuarioDAO uDao = new UsuarioDAO(); 
    private ArrayList<Usuario> usuarios;


    public MensajeDAO(/*Conexion con*/) {
        this.con = new Conexion();
        usuarios = uDao.getUsuarios(); 
    }
  
    
     public ArrayList<Mensaje> getMensaje(){
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();
        
//        Venta venta= null;
//        Vendedor vendedor = null;
        
        
        try{
            String sql="SELECT * FROM mensaje";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while ( resultados.next() ) {
          
                int id_mensaje= Integer.parseInt(resultados.getString("id_mensaje"));
                Usuario usuarioE= usuarios.get(Integer.parseInt(resultados.getString("id_usuario")));
                Usuario usuarioR= usuarios.get(Integer.parseInt(resultados.getString("id_usuario")));
                String contenido = resultados.getString("contenido");
                
                int monto = Integer.parseInt(resultados.getString("monto"));
               
                mensajes.add(new Mensaje(id_mensaje,usuarioE, usuarioR, contenido));
                
            }
            accesoBD.close();
            return mensajes;
            
        }catch(Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
        
        
    } 
     
      public boolean ingresarMensaje(Mensaje msj){
        Connection accesoBD = con.getConexion();
        boolean resp = false;
        
        try{
            String sql= "INSERT INTO mensaje VALUES ( NULL ,'"+msj.getId_mensaje()+"','"+msj.getContenido()+"', '"+msj.getEmisor()+"', '"+msj.getReceptor()+"')";
            
            Statement st = accesoBD.createStatement();
            
            st.executeUpdate(sql);
            
            resp = true;
            accesoBD.close();
            
        } catch (Exception e){
            
            System.out.println("Error");
            e.printStackTrace();
        }
        return resp;    
    }
      public ArrayList<Mensaje> getMensajesRecibidos(String recibido){
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM mensaje";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                
                 int id_mensaje= Integer.parseInt(resultados.getString("id_mensaje"));
                Usuario usuarioE= usuarios.get(Integer.parseInt(resultados.getString("id_usuario")));
                Usuario usuarioR= usuarios.get(Integer.parseInt(resultados.getString("id_usuario")));
                String contenido = resultados.getString("contenido");
                
                int monto = Integer.parseInt(resultados.getString("monto"));
               
                mensajes.add(new Mensaje(id_mensaje,usuarioE, usuarioR, contenido));
            }
            accesoBD.close();
            return mensajes;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
      }
      
      public ArrayList<Mensaje> getMensajesEnviados(int idMe){
        
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM mensaje WHERE id_usuario='"+idMe+"'";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                  
                 int id_mensaje= Integer.parseInt(resultados.getString("id_mensaje"));
                Usuario usuarioE= usuarios.get(Integer.parseInt(resultados.getString("id_usuario")));
                Usuario usuarioR= usuarios.get(Integer.parseInt(resultados.getString("id_usuario")));
                String contenido = resultados.getString("contenido");
                
              
               
                mensajes.add(new Mensaje(id_mensaje,usuarioE, usuarioR, contenido));
            }
            accesoBD.close();
            return mensajes;
            }
        
        catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
      }
}
        
    
      




