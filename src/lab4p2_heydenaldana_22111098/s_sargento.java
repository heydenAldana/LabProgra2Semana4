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
public class s_sargento extends soldado
{
    // Atributos
    private String arma;
    private int ataque;
    
    // Constrcutor
    public s_sargento (String nombre, int edad, int diasBatallando, String rango, int vit)
    {
        super(nombre, edad, diasBatallando, rango, vit);
        this.arma = "ESCOPETA";
        this.ataque = 140;
    }

    // get y set
    public String getArma() {
        return arma;
    }

    public int getAtaque() {
        return ataque;
    }
    
    // chequea los bonos (ataque extra) y lo aplica al ataque actual
    @Override
    public int ataqueextra(String tipoS)
    {
        int ataquearecibir = 0;
        if(tipoS.equalsIgnoreCase("INFANTERIA PESADA"))
            ataquearecibir = ataque + (int)(ataque * 0.10);
        if(tipoS.equalsIgnoreCase("INFANTERIA LIGERA"))
            ataquearecibir = ataque + (int)(ataque * 0.15);
        return ataquearecibir;
    }
}
