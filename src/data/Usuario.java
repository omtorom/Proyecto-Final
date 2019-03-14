package data;

public class Usuario extends Persona{
    
    private String contraseña;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
    @Override
    public String toString() {
        return ("Usuario{" + "contraseña=" + contraseña);
    }

    public Usuario(String contraseña, String nombre) {
        super(nombre);
        this.contraseña = contraseña;
    }

}
