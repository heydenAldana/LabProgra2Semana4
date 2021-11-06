/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_heydenaldana_22111098;

import java.util.Date;

/**
 *
 * @author heyde
 */
public abstract class soldado 
{
    private String nombre;
    private int edad;
    private int tiempobatalla;
    private String rango;
    private int vit;
    
    public soldado(String nombre, int edad, int diasBatallando, String rango, int vit)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.tiempobatalla = diasBatallando;
        this.rango = rango;
        this.vit = vit;
    }
    
    // get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTiempobatalla() {
        return tiempobatalla;
    }

    public void setTiempobatalla(int tiempobatalla) {
        this.tiempobatalla = tiempobatalla;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }
    
     public abstract int ataqueextra (String tipoS);
}
