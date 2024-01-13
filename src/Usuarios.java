public class Usuarios {
     private String user;
     private String nombre;
     private String password;
     private int tipo;


     //constructor
     public Usuarios(String user, String nombre, String password, int tipo) {
          this.user = user;
          this.nombre = nombre;
          this.password = password;
          this.tipo = tipo;
     }

     public Usuarios(String user) {
          this.user = user;
     }
    
     //getters y setters

     public String getUser() {
          return user;
     }

     public void setUser(String user) {
          this.user = user;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;

     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public int getTipo() {
          return tipo;
     }

     public void setTipo(int tipo) {
          this.tipo = tipo;
     }

     @Override
     public String toString() {
          return "Usuarios{" +
                  "user='" + user + '\'' +
                  ", nombre='" + nombre + '\'' +
                  ", password='" + password + '\'' +
                  ", tipo=" + tipo +
                  '}';
     }


     

}
