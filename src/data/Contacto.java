package data;

public class Contacto extends Persona{

    
    private String correo;
    private String telefono;
    private String direccion;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Override
    public String toString() {
        return getNombre()+" - "+ correo +" - "+ direccion;
    }

    public Contacto(String correo, String telefono, String nombre, String direccion) {
        super(nombre);
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }
   
}
