/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_heydenaldana_22111098;

import java.util.ArrayList;

/**
 * paso -2 elegir zona (L o V)
 * paso -1: elegir escuadron
 * paso 0: elegir soldado 
 * paso 1: determinar el turno
 * paso 2: atacar (solo el super soldado tendria opciones, los demas por su cuenta)
 * paso 3: procesar todo
 * paso 4: si no hay gane, volver al paso 1
 * paso 5: si hay ganador, deteminar conquista para visitantes o efensa par locales.
 */
public class administrador 
{
    private boolean turno1 = false, turno2 = false;
    private String[] ply = new String[1];
    private String nombreZona;
    private boolean esLocal, SUPERbatalla = false;
    
   
    private ArrayList<soldado> soldier;
    private escuadron esc;
    armas a;
    
     // ----------- ESTA PARTE ADMINISTRA LAS PELEAS ------- //
    
    // Elegir zona
    public void elegirZona(int enumeracion_zona)
    {
        try
        {
            nombreZona = esc.buscarZona(enumeracion_zona);
            System.out.println("---> ZONA ELEGIDA CON EXITO");
        } catch (Exception e) {
            System.out.println("---> ERROR. ¿ELIGIO ALGUN NUMERO DE LAS OPCIONES DISPONIBLES?");
        }
    }
    
    // Elegir Soldados
    public void elegirSoldados(int enumeracionSoldado)
    {
        try
        {
            // primero jugador 1 y luego jugador 2
            for (int i = 0; i < 2; i++) 
            {
                ply[i] = esc.buscarSoldado(enumeracionSoldado);
            }
            if(ply[0] == null)
            {
                System.out.println("---> JUGADOR 2 GANA");
                System.exit(0);
            }
            if(ply[1] == null)
            {
                System.out.println("---> JUGADOR 1 GANA");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("---> ERROR. ¿ELIGIO ALGUN NUMERO DE LAS OPCIONES DISPONIBLES?");
        }
        
    }
    
    // Deteminar turno
    public void Turno()
    {
        if(turno1 == false && turno2 == false)
        {
            turno1 = true;
            System.out.println("--- ES HORA DE J1");
        }
        if(turno1 == true && turno2 == false)
        {
            turno2 = true;
            turno1 = false;
            System.out.println("--- ES HORA DE J2");
        }
        if(turno2 == true && turno1 == false)
        {
            turno1 = true;
            turno2 = false;
            System.out.println("--- ES HORA DE J1");
        }
        atacar();
    }
    
    // ATACAR
    public void atacar()
    {
        for (int i = 0; i < 2; i++) 
        {
            if(esc.buscarTipoSoldado(ply[i]) == 1)
                SUPERbatalla = true;
        }
        
        if(turno1)
        {
            if(SUPERbatalla)
                return;
            esc.quitarVidaSoldado(ply[1]);
            System.out.println("---> J1, quien seria " + ply[0]
                + " HA HERIDO A J2");
            System.out.println("---{ J1 (" + ply[0] + "): " + esc.obtenerVITSoldado(ply[0]) + "\n"
                + "---{ J2 (" + ply[1] + "): " + esc.obtenerVITSoldado(ply[1]));
            
            
        }
        if(turno2)
        {
            if(SUPERbatalla)
                return;
            esc.quitarVidaSoldado(ply[0]);
            System.out.println("---> J2, quien seria " + ply[1]
                + " HA HERIDO A J1");
            System.out.println("---{ J2 (" + ply[1] + "): " + esc.obtenerVITSoldado(ply[1]) + "\n"
                + "---{ J2 (" + ply[0] + "): " + esc.obtenerVITSoldado(ply[0]));
           
        }
        
        Turno();
    }
    
    
   
}
