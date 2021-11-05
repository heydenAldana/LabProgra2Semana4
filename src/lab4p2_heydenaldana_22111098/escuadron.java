package lab4p2_heydenaldana_22111098;

import java.util.ArrayList;
/**
 *
 * @author heyde
 */
public class escuadron 
{
    // Atributos
    private String nombre;
    private ArrayList<zona> lugar;
    private ArrayList<soldado> soldier;
    
    // Constructor
    public escuadron (String nombre)
    {
        this.nombre = nombre;
        lugar = new ArrayList<zona>();
        soldier = new ArrayList<soldado>();
    }
    
    // Get

    public String getNombre() {
        return nombre;
    }
}
