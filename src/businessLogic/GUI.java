package businessLogic;

import data.Contacto;
import data.Usuario;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GUI {
    
    public static void ingresarUsuario(String contraseña, HashMap <String,Usuario> listaUsuarios){
    if (listaUsuarios.containsKey(contraseña)){
        String nombre=listaUsuarios.get(contraseña).getNombre();
        JOptionPane.showMessageDialog(null, "Bienvenid@ a tu agenda personal "+nombre);    
    }else{
         JOptionPane.showMessageDialog(null,"Nuevo Usuario Ingresado");
    }
    }
    
    public static void registrarUsuario(String contraseña, String nombre, HashMap <String,Usuario> listaUsuarios){
        if (listaUsuarios.containsKey(contraseña)){
        JOptionPane.showMessageDialog(null, "El usuario ya existe","",JOptionPane.WARNING_MESSAGE);     
    }else{
        Usuario usuario = new Usuario(contraseña, nombre);
        listaUsuarios.put(contraseña, usuario);
        JOptionPane.showMessageDialog(null, "Usuario Creado Exitosamente");
    }
    }

   public static void guardarContacto(String telefono, String correo, String direccion, String nombre, HashMap <String,Contacto> listaContactos){
    if (listaContactos.containsKey(telefono)) {
        JOptionPane.showMessageDialog(null, "No se puede guardar el Contacto. El Número de Teléfono ya esta registrado.","",JOptionPane.WARNING_MESSAGE);
    } else {
        Contacto c = new Contacto(correo,telefono,nombre,direccion);
        listaContactos.put( telefono, c );
        JOptionPane.showMessageDialog(null, "Contacto Creado Exitosamente");
    }
} 
   public static void modificaContacto(String telefono, HashMap<String,Contacto> listaContactos){
    Scanner sc = new Scanner(System.in);
   if (listaContactos.containsKey(telefono)) {     
        try
         {
         //Código que puede provocar errores
             String name = JOptionPane.showInputDialog("Selecciona el dato que deseas modificar: " + "\n1. Nombre"
               + "\n2. Teléfono"
               + "\n3. Dirección"
               + "\n4. Correo Electronico"
               + "\n5. Eliminar todos los datos");
            
               int opcion = Integer.parseInt(name);
        
        switch (opcion) {
            case 1:
                String suname = JOptionPane.showInputDialog("Escriba el nuevo Nombre del Contacto: ");
                listaContactos.get(telefono).setNombre(suname); 
                break;
            case 2:
                String suname1 = JOptionPane.showInputDialog("Escriba el nuevo Número de Teléfono del Contacto: ");
                listaContactos.get(telefono).setTelefono(suname1);
                break;
            case 3:
                String suname2 = JOptionPane.showInputDialog("Escriba la nueva Dirección del Contacto: ");
                listaContactos.get(telefono).setDireccion(suname2);
                break;
            case 4:
                String suname3 = JOptionPane.showInputDialog("Escriba el nuevo Correo Electronico del Contacto: "); 
                listaContactos.get(telefono).setCorreo(suname3);
                break;
            case 5:
                eliminaContacto(telefono,listaContactos);
                break;
        }
        }
        catch(NumberFormatException Exception){
            JOptionPane.showMessageDialog(null, "Error","",JOptionPane.WARNING_MESSAGE);
        }
   } else { 
       
       JOptionPane.showMessageDialog(null, "No hay ningún contacto registrado con ese Número de Teléfono.");
   }
 }
    public static void mostrarContacto(HashMap<String, Contacto> listaContactos){
    String clave;
    Iterator<String> contactos = listaContactos.keySet().iterator();
    while(contactos.hasNext()){
        clave = contactos.next();
        JOptionPane.showMessageDialog(null,"Has guardado los siguientes Contactos:\n\t" + "|  Teléfono  |  Nombre  |  Correo  |  Direccion |\n\t" + clave + " - " + listaContactos.get(clave));
    }        
}
   public static void eliminaContacto(String telefono, HashMap<String,Contacto> listaContactos) {
    if (listaContactos.containsKey(telefono)){
        listaContactos.remove(telefono);
        JOptionPane.showMessageDialog(null,"Contacto Eliminado Exitosamente");

    } else {
        
        JOptionPane.showInputDialog("No hay ningún contacto registrado con ese Número de Teléfono.");
    }  
   }  
}


