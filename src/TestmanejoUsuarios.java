
import java.sql.*;
import java.util.*;
public class TestmanejoUsuarios {
    public static void main(String[] args) {

       
        Connection conexion= null;
        try{
            conexion= Conexion.getConnection();
            if (conexion.getAutoCommit()){
               conexion.setAutoCommit(false);
            }
            
            UsuariosDAO usuarioDAO = new UsuariosDAO(conexion);
           

                //Insertar usuario
                Usuarios usuarioNuevo = new Usuarios("usuario3", "nombre3", "password3", 3);
            usuarioDAO.insertar(usuarioNuevo);   

                 //Get usuarios
            /* List<Usuarios> usuarios = usuarioDAO.seleccionar();
            for (Usuarios usuario : usuarios) {
                System.out.println( usuario);
                System.out.println("user: " + usuario.getUser());
                System.out.println("nombre: " + usuario.getNombre());
                System.out.println("password: " + usuario.getPassword());
                System.out.println("tipo: " + usuario.getTipo());
                System.out.println("");
            } */
            
                //Actualizar usuario
                /*  Usuarios usuarioActualizar = new Usuarios("usuario3", "nombrechang", "passwordcha", 3);

                usuarioDAO.actualizar(usuarioActualizar); */

                //Eliminar usuario
             /*  Usuarios usuarioEliminar = new Usuarios("usuario3");
                usuarioDAO.eliminar(usuarioEliminar);  */

                conexion.commit();
        }
        catch (SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("Se ha dado un rollback");
            try{
                    conexion.rollback();
            }
            catch (SQLException ex2){
                ex2.printStackTrace(System.out);
            }
        }


        

       
    }
}
