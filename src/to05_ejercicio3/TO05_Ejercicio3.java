/* 
 * Clase que contiene a main:Esta es la única clase encargada de interacturar con el usuario (entrada/salida por consola).
 * Apoyándose en la clase ES.java para validar la entrada del usuario mostrará un menú con las siguientes opciones:
 * Alquilar:  se pedirá el número de días de alquiler de un patinete y se devolverá el precio (10€/día o 50€/semana) de dicho alquiler. 
 * No se podrá vender o volver a alquilar ese patinete mientras dure el alquiler.
 * Devolver: cuando lo devuelva el cliente se pondrá disponible para volver a alquilar o vender.
 * Reparar: se pondrá para reparar y se pedirá el precio y descripción de la reparación.
 * Entregar: el patinete volverá a estar disponible para su alquiler o venta.
 * Comprar: se añadirá un nuevo patinete a la tienda (como máximo habrá 20 patinetes en la tienda).
 * Vender patinete: se eliminará de la tienda uno de los patinetes disponibles.
 * Ver el estado: se mostrará el estado de todos los patinetes.
 * Estadísticas: se mostrará un resumen de los alquileres, las reparaciones y las ventas realizadas (cantidad y precio total), así como el resultado de ingresos y gastos.
 * Salir.
 */
package to05_ejercicio3;
import static to05_ejercicio3.ES.*;


/**
 *
 * @author Eduardo Jośe Guirado Álvarez
 */
public class TO05_Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        int opcion; // variable para opciones del switch
        double lectura[] = {0,0};
        Tienda miTienda = new Tienda();

        do{
            msgln("┌───────────===[[[Tienda Patinetes]]]===───────────┐");
            msgln("│                                                  │");
            msgln("│ 0-> Alquilar Patinete                            │");
            msgln("│ 1-> Devolver Patinete                            │");
            msgln("│ 2-> Reparar Patinete                             │");
            msgln("│ 3-> Entregar Patinete                            │");
            msgln("│ 4-> Comprar Patinete                             │");
            msgln("│ 5-> Vender Patinete                              │");
            msgln("│ 6-> Listado de Estados de Patinete               │");
            msgln("│ 7-> Estadísticas  Tienda                         │");
            msgln("│ 8-> Salir                                        │");
            msgln("└──────────────────────────────────────────────────┘");            
            opcion = (leeEntero("Elija una de las opciones : ",0,9)); 

            
                switch(opcion){
                    case(0):
                            lectura[0] = leeEntero("Introduzca la cantidad de días que quiere alquilar el patinete:",1);//lectura de teclado
                            msgln("\u001B[46mEl coste por alquilar un Patinete \u001B[43m" + (int)lectura[0] +"\u001B[46m días es:\u001B[43m " + miTienda.calculaPrecioAlquiler((int)lectura[0])+ "\u001B[46m €\u001B[40m");
                            try{
                                miTienda.alquilar(miTienda.calculaPrecioAlquiler(((int)lectura[0])));
                                msgln("\u001B[46m Has alquilado un patinete por \u001B[43m" + (int)lectura[0] + "\u001B[46m días\u001B[40m");
                            }catch (Exception e){
                                msgln("\u001B[41m\u001B[37mLo sentimos,no hay patinetes para alquilar\u001B[0m\u001B[40m");
                            }
                        break;
                    case(1):
                            lectura[0] = leeEntero("Introduzca el código del patinete a devolver:");//lectura de teclado
                            try{
                                miTienda.devolver((int)lectura[0]);
                                msgln("\u001B[46m Se ha devuelto el patinete con código :  \u001B[43m" + (int)lectura[0] + "\u001B[40m");

                            }catch (Exception e){
                                msgln(e.getMessage());
                            }    
                        break;
                    case(2):
                            lectura[0] = leeEntero("Introduzca el código del patinete a reparar:");//lectura de teclado
                            lectura[1] = leeDouble("Introduzca el importe de la reparación:");//lectura de teclado
                            try{
                                miTienda.reparar((int)lectura[0],lectura[1]);
                                msgln("\u001B[46m Se ha puesto en reparacion el patinete con código :  \u001B[43m" + (int)lectura[0] + "\u001B[40m");

                            }catch (Exception e){
                                msgln(e.getMessage());
                            } 
                        break;
                    case(3):
                            lectura[0] = leeEntero("Introduzca el código del patinete a entrgar:");//lectura de teclado
                            try{
                                miTienda.entregar((int)lectura[0]);
                                msgln("\u001B[46m Se ha entregado el patinete con código :  \u001B[43m" + (int)lectura[0] + "\u001B[40m");

                            }catch (Exception e){
                                msgln(e.getMessage());
                            }  
                        break;
                    case(4):
                            msgln("Ha decidido usted comprar un patinete");
                            try{
                                miTienda.comprar();
                                msgln("\u001B[46mHa comprado usted un patinete");
                            }catch (Exception e){
                                msgln(e.getMessage());
                            }    
                        break;
                    case(5):
                            msgln("Ha decidido usted vender un patinete");
                            try{
                                miTienda.vender();
                                msgln("\u001B[46mSe ha vendido un patinete\u001B[40m");
                            }catch (Exception e){
                                msgln(e.getMessage());
                            } 
                        break;
                    case(6):
                            msg(miTienda.estadoPatinetes());

                        break;
                    case(7):
                            msg(miTienda.estadisticas());
                        break;

                    default:
                        break;
                }
        }while(opcion!=8);
    }
}
    
