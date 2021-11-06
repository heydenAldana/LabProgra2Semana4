/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p2_heydenaldana_22111098;

import java.util.Scanner;

/**
 *
 * @author heyde
 */
public class MainJuego 
{
    public static void main(String[] args) 
    {
        // Atributos de juego prnicipal
        int nopcion = 0;
        Scanner leer =  new Scanner(System.in);
        escuadron esc;
        administrador admin;
        
        String nombret, tipost, rangot;
        int edadt, vitt, diast;
        
        try
        {
            // Aqui arranca el juego
            do
            {
                System.out.println(" ==== ==== ==== ==== ==== ==== ==== ==== ==== ==== ==== ===="
                        + "  C A L L  O F  D U T Y  ---  M O D E R N  W A R F A R E  2 0 2 1"
                        + " 0. SALIR\n"
                        + " 1. CREAR UN SOLDADO\n"
                        + " 2. ELIMINAR UN SOLDADO\n"
                        + " 3. LISTAR LOS SOLDADOS\n"
                        + " 4. CREAR UNA ZONA\n"
                        + " 5. LISTAR ZONAS\n"
                        + " 6. CREAR UN ESCUADRON\n"
                        + " 7. ELIMINAR UN ESCUADRON\n"
                        + " 8. LISTAR LOS ESCUADRONES\n"
                        + " 9. LISTAR SOLDADOS POR ESCUADRON **\n"
                        + " 10. JUGAR\n"
                        + " - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - \n");
                nopcion = leer.nextInt();
                leer.nextLine();

                switch (nopcion)
                {
                    case 1:
                        System.out.println(" - - - >>>");
                        System.out.println("escriba el nombre del Soldado: ");
                        nombret = leer.nextLine();
                        System.out.println("Escribe cualquiera de estas opciones:\n 1. INFANTERIA LIVIANA\n 2. INFANTERIA PESADA\n 3. CAPITAN\n 4. SARGENTO\n 5. SUPERS");
                        tipost = leer.nextLine().toUpperCase();
                        System.out.println("escriba el tiempo (dias al servicio) del Soldado: ");
                        diast = leer.nextInt();
                        leer.nextLine();
                        System.out.println("Escribe un rango (ej. Comandante)");
                        rangot = leer.nextLine().toUpperCase();
                        System.out.println("escriba la vitalidad (100 - 400) del Soldado: ");
                        vitt = leer.nextInt();
                        leer.nextLine();
                        System.out.println("escriba la edad del Soldado: ");
                        edadt = leer.nextInt();
                        leer.nextLine();
                        esc.agregarSoldado(nombret, tipost, edadt, diast, rangot, vitt);
                }

            } while(nopcion != 0 || (nopcion >= 0 && nopcion < 12));
        } catch (Exception e) {
            System.out.println("L juego no arranca, pero no se detuvo el programa");
        }
        
    }
    
}
