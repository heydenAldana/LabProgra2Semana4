/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_heydenaldana_22111098;

/**
 *
 * @author heyde
 */
public class zona 
{
    // Atributos
    private String nombre;
    private int tamano;
    private int coorx, coory;
    
    // Constructor
    public zona (String nombre, int tamano, int coorx, int coory)
    {
        this.nombre = nombre;
        this.tamano = tamano;
        this.coorx = coorx;
        this.coory = coory;
    }

    // get y set
    public String getNombre() {
        return nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCoorx() {
        return coorx;
    }

    public int getCoory() {
        return coory;
    }
    
    
}
