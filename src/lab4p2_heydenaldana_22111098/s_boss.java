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

// Entiendase como super soldado
public class s_boss extends soldado
{
    // Atributos
    private int ataque;
    armas a;
    
    // Constrcutor
    public s_boss (String nombre, int edad, int diasBatallando, String rango)
    {
        super(nombre, edad, diasBatallando, rango, 1000);
        
    }

    
    // obtiene el arma que usa (su daño)
    private int tipoArma(String armat)
    {
        try
        {
            if(armat.equalsIgnoreCase(a.ARMAB.toString()))
                return 50;
            if(armat.equalsIgnoreCase(a.BOMBA.toString()))
                return 150;
            if(armat.equalsIgnoreCase("ESCOPETA"))
                return 140;
            if(armat.equalsIgnoreCase("LANZALLAMAS"))
                return 110;
        } catch (Exception e) {
            System.out.println("---> LOS DATOS NO ESTAN DISPONIBLES.");
        }
        
        return -1;
    }
    
    public int getAtaque() {
        return ataque;
    }
}
