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
        escuadron esc = new escuadron("AdministradorIgnorar");
        administrador admin = new administrador();
        
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
                        break;
                    case 2:
                        System.out.println(" - - - >>>");
                        System.out.println("escriba el numero (enumeracion) del Soldado a ELIMINAR (VER opcion 3): ");
                        int numeros = leer.nextInt();
                        leer.nextLine();
                        esc.eliminarSoldado(numeros);
                        break;
                    case 3:
                        esc.listarSoldados();
                        break;
                    case 4:
                        System.out.println(" - - - >>>");
                        System.out.println("Escribe el nombre de la zona: ");
                        String zona = leer.nextLine();
                        System.out.println("Escriba el tamaño (100-300) de la zona");
                        int tam = leer.nextInt();
                        leer.nextLine();
                        System.out.println("Escriba la coordenada x de la zona");
                        int x = leer.nextInt();
                        leer.nextLine();
                        System.out.println("Escriba la coordenada y de la zona");
                        int y = leer.nextInt();
                        leer.nextLine();
                        esc.agregarZona(zona, tam,  x, y);
                        break;
                    case 5:
                        esc.listarZonas();
                        break;
                    case 6:
                        System.out.println(" - - - >>>");
                        System.out.println("Escriba el nombre del escuadron: ");
                        String nombreescuadron = leer.nextLine();
                        esc.agregarEscuadron(nombreescuadron);
                        break;
                    case 7:
                        System.out.println(" - - - >>>");
                        System.out.println("escriba el numero (enumeracion) del Soldado a ELIMINAR (VER opcion 3): ");
                        int numeroe = leer.nextInt();
                        leer.nextLine();
                        esc.eliminarEscuadron(numeroe);
                        break;
                    case 8:
                        esc.listarEscuadrones();
                        break;
                    case 9:
                        System.out.println("Escriba el nombre del escuadron de parametro: ");
                        String escb = leer.nextLine();
                        System.out.println("Escriba el TIPO de SOLDADO ( INFANTERIA LIGERA || INFANTERIA PESADA || CAPITAN || SARGENTO || SUPERS ) de parametro: ");
                        String tiposb = leer.nextLine();
                        esc.listarSoldadosPorTipoEnEscuadron(escb, tiposb);
                        break;
                    case 10:
                        // paso -2
                        esc.listarZonas();
                        System.out.println("---> Eliga un numero (Zona): ");
                        int nzone = leer.nextInt();
                        leer.nextLine();
                        admin.elegirZona(nzone);
                        
                        // paso -1
                        esc.listarSoldados();
                        System.out.println("---> Eliga un numero (Zona): ");
                        int nsol = leer.nextInt();
                        leer.nextLine();
                        admin.elegirSoldados(nsol);
                        
                        // paso 0
                        admin.Turno();
                        
                        // el resto se juega solo... creo.
                        break;
                }

            } while(nopcion != 0 || (nopcion >= 0 && nopcion < 11));
        } catch (Exception e) {
            System.out.println("L juego no arranca, pero no se detuvo el programa");
        }
        
    }
    
}
