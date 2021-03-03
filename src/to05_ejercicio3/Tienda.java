/* Clase Tienda que contiene:
 * Constantes públicas: MAXIMONUMPATINETES (20)
 * Atributos: los necesarios para determinar cuántos patinetes hay en total (como mucho MAXIMONUMPATINETES),
 * gestionar los códigos que se asignan a los patinetes al comprarlos, contabilidad de ingresos/gastos y el estado 
 * en que se encuentra cada uno de los patinetes (para esto último se usará un array de objetos Patinete).
 * Métodos públicos:
 * public double CalculaPrecioAlquiler (int diasTotales). A partir del número de días que dura el alquiler devuelve cuánto costaría ese alquiler.
 * public void Alquilar(double precioAlquiler) throws Exception. A partir del precio del alquiler pasa a estado ALQUILADO cualquiera de los patinetes disponibles. Actualiza estadísticas de alquiler.
 * public void Devolver (int codigo) throws Exception. A partir de un codigo de patinete ya alquilado cambia su estado a DISPONIBLE.
 * public void Reparar (int codigo, double precioReparacion) throws Exception. A partir de un codigo de patinete disponible o alquilado 
 * y el coste de la reparación pasa su estado a ENREPARACION. Actualiza estadísticas de reparaciones.
 * public void Entregar (int codigo) throws Exception. A partir de un codigo de patinete averiado pasa su estado a DISPONIBLE.
 * public void Comprar() throws Exception. Añade un nuevo patinete a la tienda, asignándole un codigo único. Actualiza estadísticas de compras.
 * public void Vender() throws Exception. Elimina de la tienda cualquier patinete disponible. Actualiza estadísticas de ventas.
 * public String EstadoPatinetes(). Genera un String con en el que se indica el codigo y el estado de cada uno de los patinetes.
 * public String Estadisticas().  Genera un String que contiene un resumen con las estadísticas indicadas anteriormente.
 * Métodos privados:
 * Aquellos que consideres oportunos. Por ejemplo, puesto que los patinetes se guardan en un array pero los identificamos mediante codigos, 
 * pueden ser útiles métodos que devuelvan determinada información sobre un patinete a partir de su código, como su estado, si existe dicho código,
 * el valor del índice que le corresponde en el array, eliminar dicho patinete del array ... y cualquier otro que estimes necesario.
 * Excepciones: la clase Tienda NUNCA mostrará mensajes por pantalla ante cualquier situación de error, 
 * sino que los métodos anteriores provocarán excepciones que serán capturadas por los llamantes. Entre ellas, tendremos, al menos, las siguientes:
 *       "El patinete con código XXXXX no existe".
 *       "No quedan patinetes para alquilar".
 *       "No se puede devolver porque no existe"
 *       "No se puede devolver porque no está alquilado"
 *       "No se puede reparar porque no existe"
 *       "No se puede reparar porque ya está puesto a reparar"
 *       "No se puede entregar porque no existe"
 *       "No se puede entregar porque no está puesto a reparar"
 *       "No se puede comprar porque se ha alcanzado el máximo de patinetes en la tienda"
 *       "No se puede vender porque no quedan patinetes en stock"
 *       "No se puede vender porque ahora mismo no hay disponibles"
 */
package to05_ejercicio3;
/**
 *
 * @author Eduardo Jośe Guirado Álvarez
 */
public class Tienda {
    
    private final  int MAXIMONUMPATINETES = 20;
    private Patinete arrayPatinete[] = new Patinete[MAXIMONUMPATINETES];
    private double ingresos = 0;
    private double gastos = 0;
    private int alquileres = 0;
    private int compras = 0;
    private int ventas = 0;
    private int reparaciones = 0;
    private int posicionCompra = 0;
    private int posicionCodigo = 0;

    public Patinete[] getArrayPatinete(int pos) {
        return arrayPatinete;
    }

    
    public Tienda (){ // constructor
    }
    
    public double calculaPrecioAlquiler(int diasTotales){
        int dias = diasTotales % 7; // devuelve días sueltos
        int semanas = diasTotales / 7;// devuelve semanas
        double alquilerSemanal = 50;
        double alquilerDia = 10;
        return ((alquilerSemanal * semanas)+(alquilerDia * dias));
    }
   

    public void alquilar(double precioAlquiler) throws Exception{

        int disponibles = 0;
        boolean alquilado = false;
        for(int i = 0;i < posicionCompra;i++){
            if(arrayPatinete[i].getEstado().equals(Estado.DISPONIBLE) && alquilado == false){
                disponibles++;
                arrayPatinete[i].setEstadoPatinete(Estado.ALQUILADO);
                alquileres++;
                ingresos = ingresos + precioAlquiler;
                alquilado = true;
            }
        }
        if(disponibles==0){
                
                    throw new Exception("\u001B[41m\u001B[37mNo quedan patinetes para alquilar\u001B[0m\u001B[40m");
        }

        
    }
    public void devolver (int codigo) throws Exception{
        
        if(obtenerPosicionPorCodigo(codigo) == -13){
            throw new Exception("\u001B[41m\u001B[37mNo se puede devolver porque no existe\u001B[0m\u001B[40m");
        }
        if(arrayPatinete[obtenerPosicionPorCodigo(codigo)].getEstado().equals(Estado.ALQUILADO) ){
                    
            arrayPatinete[obtenerPosicionPorCodigo(codigo)].setEstadoPatinete(Estado.DISPONIBLE);

        }else{
                throw new Exception("\u001B[41m\u001B[37mNo se puede devolver porque no está alquilado\u001B[0m\u001B[40m");
        }
        
    }
    
    public void reparar (int codigo, double precioReparacion) throws Exception{
        
        if(obtenerPosicionPorCodigo(codigo) == -13){
            throw new Exception("\u001B[41m\u001B[37mNo se puede reparar porque no existe\u001B[0m\u001B[40m");
        }
        if(arrayPatinete[obtenerPosicionPorCodigo(codigo)].getEstado().equals(Estado.ALQUILADO) ||
                arrayPatinete[obtenerPosicionPorCodigo(codigo)].getEstado().equals(Estado.DISPONIBLE)){
                    
            arrayPatinete[obtenerPosicionPorCodigo(codigo)].setEstadoPatinete(Estado.ENREPARACION);
            reparaciones++;
            gastos = gastos + precioReparacion;
            

        }else{
                throw new Exception("\u001B[41m\u001B[37mNo se puede reparar porque ya está puesto a reparar\u001B[0m\u001B[40m");
        }
        
    }

    public void entregar (int codigo) throws Exception{
        
        if(obtenerPosicionPorCodigo(codigo) == -13){
            throw new Exception("\u001B[41m\u001B[37mNo se puede entregar porque no existe\u001B[0m\u001B[40m");
        }
        if(arrayPatinete[obtenerPosicionPorCodigo(codigo)].getEstado().equals(Estado.ENREPARACION) ){
                    
            arrayPatinete[obtenerPosicionPorCodigo(codigo)].setEstadoPatinete(Estado.DISPONIBLE);

        }else{
                throw new Exception("\u001B[41m\u001B[37mNo se puede entregar porque no está puesto a reparar\u001B[0m\u001B[40m");
        }
        
    }
    public void comprar() throws Exception{
        
        if(posicionCompra >= MAXIMONUMPATINETES){
            throw new Exception ("\u001B[41m\u001B[37mNo se puede comprar porque se ha alcanzado el máximo de patinetes en la tienda\u001B[0m\u001B[40m");
            }else{
                arrayPatinete[posicionCompra]=new Patinete(posicionCodigo+20210);
                posicionCodigo++;
                posicionCompra++;
                compras++;
                gastos = gastos + Patinete.getPRECIOCOMPRA();
            }
        }
    
    public void vender() throws Exception{
        
        int noDisponibles = 0;
        boolean vendido = false;
        if(posicionCompra == 0){
            throw new Exception("\u001B[41m\u001B[37mNo se puede vender porque no quedan patinetes en stock\u001B[0m\u001B[40m");
        }
        for(int i = 0;i < posicionCompra;i++){
            if(arrayPatinete[i].getEstado().equals(Estado.ALQUILADO) || arrayPatinete[i].getEstado().equals(Estado.ENREPARACION)){
                noDisponibles++;
            }
        }
        if(noDisponibles >= posicionCompra){
            throw new Exception("\u001B[41m\u001B[37mNo se puede vender porque ahora mismo no hay disponibles\u001B[0m\u001B[40m");
        }
        for(int i = 0;i < posicionCompra;i++){
            if((arrayPatinete[i].getEstado().equals(Estado.DISPONIBLE))&&(vendido == false)){
                eliminarLineaArray(i);
                ventas++;
                ingresos = ingresos + Patinete.getPRECIOVENTA();
                vendido = true;
            }
        }
        

        
    }
    public String estadoPatinetes(){
        
        StringBuilder listaEstados = new StringBuilder();
        for(int i = 0;i < posicionCompra;i++){
            listaEstados.append("Patinete--" + arrayPatinete[i].getCODIGOID() + "--");
            listaEstados.append(arrayPatinete[i].getEstado());
            listaEstados.append("\n");
        }
        listaEstados.append("\n");
      return listaEstados.toString();  
    }
    
    public String estadisticas(){
        
        StringBuilder estadisticas = new StringBuilder();
        estadisticas.append("---------===={ESTADÍSTICAS}===---------\n\n");
        estadisticas.append("-- Alquileres...................:" + alquileres +" \n");
        estadisticas.append("-- Reparaciones.................:" + reparaciones +" \n");
        estadisticas.append("-- Ventas.......................:" + ventas +" \n");
        estadisticas.append("-- Compras......................:" + compras +" \n");
        estadisticas.append("----------------------------------------------\n");
        estadisticas.append("-- Ingresos Totales.............:" + ingresos +" \n");
        estadisticas.append("-- Gastos Totales...............:" + gastos +" \n");
        estadisticas.append("-- Ganancias Totales............:" + (ingresos - gastos) +" \n");
        estadisticas.append("-- ......................................\n");
        estadisticas.append("--------------------------------------------\n");
        
        return estadisticas.toString();
    }
    
    public void eliminarLineaArray(int indice){
        
        Patinete arrayPatineteCopia[] = new Patinete[MAXIMONUMPATINETES];
        System.arraycopy(arrayPatinete, 0, arrayPatineteCopia, 0, posicionCompra);
        
        
        if(indice == 0){
            
            System.arraycopy(arrayPatineteCopia, indice+1, arrayPatinete, indice, posicionCompra -1);
            posicionCompra--;
        }else{
      
            if(indice == MAXIMONUMPATINETES -1){
            
                System.arraycopy(arrayPatineteCopia, 0, arrayPatinete, 0, indice);
                posicionCompra--;

            }else{
            
                    System.arraycopy(arrayPatineteCopia, 0, arrayPatinete, 0, indice );
                    System.arraycopy(arrayPatineteCopia, indice+1, arrayPatinete, indice , posicionCompra-indice-1);
                    posicionCompra--;
            }
        }
        
    }
    

    public int obtenerPosicionPorCodigo(int codigo){
        
        int codigoEncontrado = -13;
        for(int i = 0;i < posicionCompra;i++){
            if(arrayPatinete[i].getCODIGOID() == codigo){
                   codigoEncontrado = i;
            }       
        }
        return codigoEncontrado;
    }
    
    public int obtenerCodigoporPosicion(int posicion){
        
        return arrayPatinete[posicion].getCODIGOID();
        
    }


    
}
