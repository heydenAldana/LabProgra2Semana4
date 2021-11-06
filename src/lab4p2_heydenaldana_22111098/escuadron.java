package lab4p2_heydenaldana_22111098;

import java.util.ArrayList;

/**
 * ES PARA EL OBJETO DE ESCUADRON PERO TERMINE CREANDO TODO AQUI
 * GRACIAS A LOS ARRAYS DE SOLDADO Y ZONA
 */

public class escuadron 
{
    // Atributos
    private String nombre;
    private ArrayList<zona> lugar;
    private ArrayList<soldado> soldier;
    private ArrayList<escuadron> esc;
    
    // Constructor de escuadron
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
    
     // Agregar soldados
    public void agregarSoldado(String nombre, String tiposoldado, int edad, int diasBatallando, String rango, int vit)
    {
        // Cuenta a los capitanesy supersoldados
        int capi = 0, sboss = 0;
        for (soldado sol : soldier) 
        {
            if(sol instanceof s_capitan)
                capi++;
            if(sol instanceof s_boss)
                sboss++;
            if(capi >= 2 || sboss >= 1)
            {
                System.out.println("---> NO PUEDES AGREGAR MAS SOLDADOS DE ESTE TIPO");
                break;
            }
        }
        
        // Agrega segun el tipo
        if(tiposoldado.equalsIgnoreCase("INFANTERIA LIGERA"))
            soldier.add(new s_inf_lig(nombre, edad, diasBatallando, rango, vit));
        else if(tiposoldado.equalsIgnoreCase("INFANTERIA PESADA"))
            soldier.add(new s_inf_pes(nombre, edad, diasBatallando, rango, vit));
        else if(tiposoldado.equalsIgnoreCase("CAPITAN"))
            soldier.add(new s_capitan(nombre, edad, diasBatallando, rango, vit));
        else if(tiposoldado.equalsIgnoreCase("SARGENTO"))
            soldier.add(new s_sargento(nombre, edad, diasBatallando, rango, vit));
        else if(tiposoldado.equalsIgnoreCase("SUPERS"))
            soldier.add(new s_boss(nombre, edad, diasBatallando, rango));
    }
    
    // Lista los soldados que hay
    public void listarSoldados()
    {
        int codigo = 0;
        System.out.println("\t\t---------------------------------------------");
        for (soldado sol : soldier) 
        {
            System.out.println("Enumeracion: " + codigo + ", " + sol.getNombre() + ", " + sol.getEdad() + ", " + sol.getTiempobatalla() + "dias, " + sol.getRango() + ", " + sol.getVit() + " VIT.");
            codigo++;
        }
        System.out.println("\t\t---------------------------------------------");
    }
    
    // eliminar soldados
    public void eliminarSoldado(int enumeracion)
    {
        listarSoldados();
        try
        {
            soldier.remove(enumeracion);
            System.out.println("---> ELIMINADO");
        } catch (Exception e) {
            System.out.println("---> ESTA ENUMERACION ESTA FUERA DEL RANGO DE 0 - " + soldier.size());
        }
    }
    
    // Seleccionar un soldado
    public String buscarSoldado(int enumeracion)
    {
        listarSoldados();
        try
        {
            return soldier.get(enumeracion).getNombre();
        } catch (Exception e) {
            System.out.println("---> ESTA ENUMERACION ESTA FUERA DEL RANGO DE 0 - " + soldier.size());
        }
        return null;
    }
    
    // busca a ver si es super soldado
    public int buscarTipoSoldado(String nombreSoldado)
    {
        try
        {
            for (soldado sol : soldier) 
            {
                if(nombreSoldado.equalsIgnoreCase(sol.getNombre()) && sol instanceof s_boss)
                    return 1; 
                else if(nombreSoldado.equalsIgnoreCase(sol.getNombre()) && sol instanceof s_sargento)
                    return 2;
                else if(nombreSoldado.equalsIgnoreCase(sol.getNombre()) && sol instanceof s_capitan)
                    return 3; 
                else if(nombreSoldado.equalsIgnoreCase(sol.getNombre()) && sol instanceof s_inf_pes)
                    return 4; 
            }
            
        } catch (Exception e) {
            System.out.println("---> ERROE DE LECTURA DE DATOS");
        }
        return 5; //  que es infanteria liviana
    }
    
    
    // Funcion EXCLUSIVA para ataqueextra(String tipoS) en soldado.java
    public String tipoSoldado(String nombreSoldado)
    {
        try
        {
            for (soldado sol : soldier) 
            {
                if(nombreSoldado.equalsIgnoreCase(sol.getNombre()) && sol instanceof s_sargento)
                    return "SARGENTO";
                else if(nombreSoldado.equalsIgnoreCase(sol.getNombre()) && sol instanceof s_capitan)
                    return "CAPITAN"; 
                else if(nombreSoldado.equalsIgnoreCase(sol.getNombre()) && sol instanceof s_inf_pes)
                    return "INFANTERIA PESADA"; 
            }
            
        } catch (Exception e) {
            System.out.println("---> ERROE DE LECTURA DE DATOS");
        }
        return "INFANTERIA LIGERA"; //  que es infanteria liviana
    }
    
    // Le quita VIT  a un soldado
    public void quitarVidaSoldado(String atacado)
    {
        try
        {
            for (soldado sol : soldier) 
            {
                if(atacado.equalsIgnoreCase(sol.getNombre()))
                {
                    sol.setVit(sol.getVit() - sol.ataqueextra(tipoSoldado(atacado)));
                    estaMuerto(atacado);
                }
            }
        } catch (Exception e) {
            System.out.println("---> SALGASE DEL JUEGO, NO PUEDE SEGUIR JUGANDO PORQUE NO DBEERIA DE PASAR");
        }
        
    }
    
    
    public int obtenerVITSoldado(String soldado)
    {
        try
        {
            for (soldado sol : soldier) 
            {
                if(sol.getNombre().equalsIgnoreCase(soldado))
                    return sol.getVit();
            }
            
        } catch (Exception e) {
            System.out.println("---> ERROR DE LECTURA DE DATOS");
        }
        return -1;
    }
    
    
    // Determina si esta muerto
    public boolean estaMuerto(String atacado)
    {
        try
        {
            for (soldado sol : soldier) 
            {
                if(atacado.equalsIgnoreCase(sol.getNombre()) && sol.getVit() <= 0)
                    return true;
            }
        } catch (Exception e) {
            System.out.println("---> SALGASE DEL JUEGO, NO PUEDE SEGUIR JUGANDO PORQUE NO DBEERIA DE PASAR");
        }
        return false;
    }
    
    
    
    // ----------------------------------------- //
    
    // agregar zonas
    public void agregarZona(String nombre, int tamaño, int coordenadax, int coordenaday)
    {
        try
        {
            
        } catch (Exception e) {
            System.out.println("---> DATOS INVALIDOS.");
        }
    }
    
    // Listar zonas
    public void listarZonas()
    {
        int codigo = 0;
        System.out.println("\t\t---------------------------------------------");
        for (zona z : lugar) 
        {
            System.out.println("Enumeracion: " + codigo + ", nombre: " + z.getNombre() + ", tamaño: " +  z.getTamano() + ", X: " + z.getCoorx() + ", Y: " + z.getCoory());
            codigo++;
        }
        System.out.println("\t\t---------------------------------------------");
    }
    
    public void eliminarZona(int enumeracion)
    {
        listarZonas();
        try
        {
            lugar.remove(enumeracion);
            System.out.println("---> ELIMINADO");
        } catch (Exception e) {
            System.out.println("---> ESTA ENUMERACION ESTA FUERA DEL RANGO DE 0 - " + soldier.size());
        }
    }
    
    public String buscarZona(int enumeracion)
    {
        listarZonas();
        try
        {
            return lugar.get(enumeracion).getNombre();
        } catch (Exception e) {
            System.out.println("---> ESTA ENUMERACION ESTA FUERA DEL RANGO DE 0 - " + soldier.size());
        }
        return null;
    }
    
   
    // -------------------------------------------------- //
    
    // agregar un escuadron
    public void agregarEscuadron (String nombre)
    {
        try
        {
            esc.add(new escuadron(nombre));
        } catch (Exception e) {
            System.out.println("---> ERROR. NO SE PUDO AGREGAR");
        }
    }
    
    // Listar escuadrones;
    public void listarEscuadrones()
    {
        int codigo = 0;
        System.out.println("\t\t---------------------------------------------");
        for (escuadron e : esc) 
        {
            System.out.println("Enumeracion: " + codigo + ", Nombre: " + e.getNombre());
            codigo ++;
        }
        System.out.println("\t\t---------------------------------------------");
    }
    
    
    // listar soldados por tipo segun escuadron
    public void listarSoldadosPorTipoEnEscuadron(String nombreEscuadron, String tipoSoldado)
    {
        int codigo = 0;
        System.out.println("\t\t---------------------------------------------");
        try
        {
            for (escuadron e : esc) 
            {
                if(e.getNombre().equalsIgnoreCase(nombreEscuadron))
                {
                    for (soldado sol : soldier) 
                    {
                        if(tipoSoldado.equalsIgnoreCase("INFNATERIA LIGERA") && sol instanceof s_inf_lig)
                        {
                            System.out.println("Escuadron " + nombreEscuadron + " - Enumeracion: " + codigo + ", Nombre del soldado: " + soldier.get(codigo).getNombre());
                            codigo ++;
                        }
                        else if(tipoSoldado.equalsIgnoreCase("INFNATERIA PESADA") && sol instanceof s_inf_pes)
                        {
                            System.out.println("Escuadron " + nombreEscuadron + " - Enumeracion: " + codigo + ", Nombre del soldado: " + soldier.get(codigo).getNombre());
                            codigo ++;
                        }
                        else if(tipoSoldado.equalsIgnoreCase("CAPITAN") && sol instanceof s_capitan)
                        {
                            System.out.println("Escuadron " + nombreEscuadron + " - Enumeracion: " + codigo + ", Nombre del soldado: " + soldier.get(codigo).getNombre());
                            codigo ++;
                        }
                        else if(tipoSoldado.equalsIgnoreCase("SARGENTO") && sol instanceof s_sargento)
                        {
                            System.out.println("Escuadron " + nombreEscuadron + " - Enumeracion: " + codigo + ", Nombre del soldado: " + soldier.get(codigo).getNombre());
                            codigo ++;
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("---> ERROR DE LECTURA DE DATOS.");
        }
        
        System.out.println("\t\t---------------------------------------------");
    }
    
    // Eliminar escuadron por enumeracion
    public void eliminarEscuadron (int enumeracion)
    {
        listarEscuadrones();
        try
        {
            esc.remove(enumeracion);
            System.out.println("---> ELIMINADO");
        } catch (Exception e) {
            System.out.println("---> ESTA FUERA DEL RANGO DE LA ENUMERACION");
        }
    }
    
    // Seleccionar un escuadron
    public String buscarEscuadron(int enumeracion)
    {
        listarEscuadrones();
        try
        {
            return esc.get(enumeracion).getNombre();
        } catch (Exception e) {
            System.out.println("---> ESTA ENUMERACION ESTA FUERA DEL RANGO DE 0 - " + soldier.size());
        }
        return null;
    }
    
    // Contar escuadrones
    public int contarEscuadrones()
    {
        return esc.size();
    }
}
