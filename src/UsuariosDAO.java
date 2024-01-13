import java.sql.*;
import java.util.*;

public class UsuariosDAO {
    //se puede ejecutar mas de una sentencia 
    private Connection conexiontransaccional;

    private static final String SQL_SELECT = "SELECT * FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(user, nombre, password, tipo) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, password = ?, tipo = ? WHERE user = ?";

    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE user = ?";

     //constructor vacio
    public UsuariosDAO(){
        
    }

    //constructor transaccional
    public UsuariosDAO(Connection conexiontransaccional){
        this.conexiontransaccional = conexiontransaccional;
    }

    public List<Usuarios> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuarios usuario = null;
        List<Usuarios> usuarios = new ArrayList<>();

        try{

            conn = this.conexiontransaccional != null ? this.conexiontransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String user = rs.getString("user");
                String nombre = rs.getString("nombre");
                String password = rs.getString("password");
                int tipo = rs.getInt("tipo");
                usuario = new Usuarios(user, nombre, password, tipo);
                usuarios.add(usuario);
            }}
        
        finally{

            try{
                Conexion.close(rs);
                Conexion.close(stmt);
                if(this.conexiontransaccional == null){
                    Conexion.close(conn);
                }
            }
            catch (SQLException ex){
                ex.printStackTrace(System.out);
            }

        }
        return usuarios;
        
    
    }

    public int insertar(Usuarios usuario) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registrosInsertados = 0;
        try{

            conn = this.conexiontransaccional != null ? this.conexiontransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getPassword());
            stmt.setInt(4, usuario.getTipo());
            registrosInsertados = stmt.executeUpdate();
        } 
        finally{
            try{
               Conexion.close(stmt);
                if(this.conexiontransaccional == null){
                    Conexion.close(conn);
                }
            }
            catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return registrosInsertados;
        
    }



    public int actualizar(Usuarios usuario) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registrosInsertados = 0;
        try{

             conn = this.conexiontransaccional != null ? this.conexiontransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
           
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getTipo());
            stmt.setString(4, usuario.getUser());
            registrosInsertados = stmt.executeUpdate();
        } 
        finally{
            try{
               Conexion.close(stmt);
                if(this.conexiontransaccional == null){
                    Conexion.close(conn);
                }
            }
            catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return registrosInsertados;
        
    }

     public int eliminar(Usuarios usuario) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try{

             conn = this.conexiontransaccional != null ? this.conexiontransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, usuario.getUser());
            registros = stmt.executeUpdate();
        } 
        finally{
            try{
               Conexion.close(stmt);
               if(this.conexiontransaccional == null){
                    Conexion.close(conn);
                }
            }
            catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return registros;
        
    }
}
