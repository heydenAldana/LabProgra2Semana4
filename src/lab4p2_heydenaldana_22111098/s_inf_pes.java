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
public class s_inf_pes extends soldado
{
    // Atributos
    private String arma;
    private int ataque;
    armas a;
    
    // Constrcutor
    public s_inf_pes (String nombre, int edad, int diasBatallando, String rango, int vit)
    {
        super(nombre, edad, diasBatallando, rango, vit);
        this.arma = a.BOMBA.toString();
        this.ataque = a.BOMBA.getAtaque();
    }

    // get y set
    public String getArma() {
        return arma;
    }

    public int getAtaque() {
        return ataque;
    }
    
    
    // Determina el daño extra favorable al soldado
    public int ataqueextra(String tipoS)
    {
        int ataquearecibir = 0;
        if(tipoS.equalsIgnoreCase("INFANTERIA LIGERA"))
            ataquearecibir += (ataque + ((int)ataque * 0.15));
        return ataquearecibir;
    }
}
