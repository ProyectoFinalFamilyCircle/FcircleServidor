package hibernate;
// Generated 29-may-2015 21:18:46 by Hibernate Tools 4.3.1



/**
 * Recado generated by hbm2java
 */
public class Recado  implements java.io.Serializable {


     private Integer id;
     private String titulo;
     private String descripcion;
     private String usuarioCreador;
     private String usuarioReceptor;

    public Recado() {
    }

	
    public Recado(String titulo, String usuarioCreador, String usuarioReceptor) {
        this.titulo = titulo;
        this.usuarioCreador = usuarioCreador;
        this.usuarioReceptor = usuarioReceptor;
    }
    public Recado(String titulo, String descripcion, String usuarioCreador, String usuarioReceptor) {
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.usuarioCreador = usuarioCreador;
       this.usuarioReceptor = usuarioReceptor;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUsuarioCreador() {
        return this.usuarioCreador;
    }
    
    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }
    public String getUsuarioReceptor() {
        return this.usuarioReceptor;
    }
    
    public void setUsuarioReceptor(String usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }




}


