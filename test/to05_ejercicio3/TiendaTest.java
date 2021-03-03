/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to05_ejercicio3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduardo Jośe Guirado Álvarez
 */
public class TiendaTest {
    
    public TiendaTest() {
    }
    
    private void mensajeOk(){
    System.out.print("\33[32m SUPERADO!");
    System.out.println("\33[00m");      
        
    }
    private void mensajeError(){
    System.out.print("\33[31m ERROR!");
    System.out.println("\33[00m"); 
    }
    private void mensajeInicio(String Mensaje){
        System.out.println(Mensaje);
    }
    /**
     * Test of CalculaPrecioAlquiler method, of class Tienda.
     */
    @Test
    public void testCalculaPrecioAlquiler() {
        mensajeInicio("Test CalculaPrecioAlquiler de 76 dias");
        int diasTotales = 76;
        Tienda miTienda = new Tienda();
        double resultadoEsperado = 560;
        double resultado = miTienda.calculaPrecioAlquiler(diasTotales);
        assertEquals(resultadoEsperado, resultado, 0.0);
        mensajeOk();
    }

    /**
     * Test of Alquilar method, of class Tienda.
     */
    @Test
    public void testAlquilarPatineteCuandoNoHayDisponibles() throws Exception {
        mensajeInicio("test Alquilar Patinete Cuando No Hay Disponibles");
        Tienda miTienda = new Tienda();
        for(int i = 0; i < 5 ;i++){ //compramos 5 patinetes
            try{
                miTienda.comprar();  //compro 5 patinetes
            }catch (Exception e){
                System.out.println(e.getMessage()); //excepcion de comprar
            }
        }
        for(int i = 0; i < 5 ;i++){ //
            try{
                
                miTienda.reparar(miTienda.obtenerCodigoporPosicion(i), 25.6); //pongo 5 patinetes en reparación
            }catch (Exception e){
                System.out.println(e.getMessage()); //excepcion de repara
            }
        }
        
        try{
            miTienda.alquilar(300);//alquilamos patinete
            fail("Alquila un patinete en ENREPARACION");
        }catch(Exception e){
                mensajeOk();
                assertTrue(true);
        }


    }
    
        /**
     * Test of Alquilar method, of class Tienda.
     */
    @Test
    public void testAlquilarPatineteCuandoNoHayStock() throws Exception {
        mensajeInicio("test Alquilar Patinete Cuando No Hay Stock");
        Tienda miTienda = new Tienda();
      
        try{
            miTienda.alquilar(300);//alquilamos patinete
            fail("Alquila un patinete que no existe");
        }catch(Exception e){
                mensajeOk();
                assertTrue(true);
        }


    }
    
        /**
     * Test of Alquilar method, of class Tienda.
     */
    @Test
    public void testAlquilar5PatinetesDisponibles() throws Exception {
        mensajeInicio("test Alquilar 5 Patinetes Disponible");
        int contador = 0;
        Tienda miTienda = new Tienda();
        for(int i = 0; i < 6 ;i++){
            try{
                miTienda.comprar();  //compro  5 patinete
            }catch (Exception e){
                System.out.println(e.getMessage()); //excepcion de comprar
            }   
        }
        for(int i = 0; i < 5 ;i++){
            try{
                miTienda.alquilar(300);//alquilamos 5 patinete
                contador++;

            }catch (Exception e){
                fail("No alquila patinetes disponible");
            }
        }
        if(contador == 5){
            mensajeOk();
            assertTrue(true);    
        }
    }

    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testDevolverPatinete() throws Exception {
        mensajeInicio("test Devolver Patinete");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        miTienda.alquilar(120);
        try{
            miTienda.devolver(20210);//devolvemos patinete
            mensajeOk();
            assertTrue(true);
        }catch(Exception e){
            fail(e.getMessage());
        }

    }
    
        /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testDevolverPatineteQueNoExiste() throws Exception {
        mensajeInicio("test Devolver Patinete Que No Existe");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        miTienda.alquilar(120);
        try{
            miTienda.devolver(21210);//devolvemos patinete
            fail("Devuelve patinetes que no existen");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
            /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testDevolverPatineteQueNoEstaAlquilado() throws Exception {
        mensajeInicio("test Devolver Patinete Que No Esta Alquilado");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        try{
            miTienda.devolver(20210);//devolvemos patinete
            fail("Devuelve patinetes que no estan alquilados");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }

    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testRepararPatineteAlquilado() throws Exception {
        mensajeInicio("test Reparar Patinete Alquilado");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        miTienda.alquilar(120);
        try{
            miTienda.reparar(20210,100);//reparamos patinete
            mensajeOk();
            assertTrue(true);
        }catch(Exception e){
            fail(e.getMessage());
        }

    }
    
    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testRepararPatineteDisponible() throws Exception {
        mensajeInicio("test Reparar Patinete Disponible");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        try{
            miTienda.reparar(20210,100);//reparamos patinete
            mensajeOk();
            assertTrue(true);
        }catch(Exception e){
            fail(e.getMessage());
        }

    }
    
    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testRepararPatineteYaEnReparacion() throws Exception {
        mensajeInicio("test Reparar Patinete Ya En Reparacion");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        miTienda.reparar(20210,100);
        try{
            miTienda.reparar(20210,100);//reparamos patinete
            fail("Permite poner en reparación un patinete que ya lo esta");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testRepararPatineteQueNoExiste() throws Exception {
        mensajeInicio("test Reparar Patinete Que No Existe");
        Tienda miTienda = new Tienda();
        //miTienda.comprar();
        try{
            miTienda.reparar(20210,100);//reparamos patinete
            fail("Permite poner en reparación un patinete que no existe");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
    

    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testEntregarPatineteQueNoExiste() throws Exception {
        mensajeInicio("test Entregar Patinete Que No Existe");
        Tienda miTienda = new Tienda();
        //miTienda.comprar();
        try{
            miTienda.entregar(20210);//entregamos patinete
            fail("Permite entregar un patinete que no existe");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }

    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testEntregarPatineteQueNoEstaEnReparacion() throws Exception {
        mensajeInicio("test Entregar Patinete Que No Esta En Reparación");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        try{
            miTienda.entregar(20210);//entregamos patinete
            fail("Permite entregar un patinete que no esta en reparación");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
        /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testEntregarPatineteEnReparacion() throws Exception {
        mensajeInicio("test Entregar Patinete En Reparación");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        miTienda.reparar(20210, 20);
        try{
            miTienda.entregar(20210);//entregamos patinete
            mensajeOk();
            assertTrue(true);

        }catch(Exception e){
            fail("No permite entregar un patinete en reparación");

        }

    }

    
    /**
     * Test of Comprar method, of class Tienda.
     */
    @Test
    public void testComprarPatinete() throws Exception {
        mensajeInicio("Test Comprar Patinete");
        Tienda miTienda = new Tienda();
        try{
            miTienda.comprar();
            mensajeOk();
            assertTrue(true);
        }catch (Exception e){
        mensajeError();    
        fail(e.getMessage());
        
        }
    }

    /**
     * Test of Comprar method, of class Tienda.
     */
    @Test
    public void testComprarPatineteCuandoYaHaLlegadoAlMaxiMoStock() throws Exception {
        mensajeInicio("test Comprar Patinete Cuando Ya Ha Llegado Al MáxiMo Stock");
        Tienda miTienda = new Tienda();
        for(int i = 0; i < 20 ;i++){
            miTienda.comprar();  //compro  
        }        
        try{
            miTienda.comprar();//compramos patinete
            fail("Permite comprar un patinete cualdo se ha alcanzado el máximo stock");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }    
    /**
     * Test of Vender method, of class Tienda.
     */

    @Test
    public void testVenderPatineteCuandoNoHayStock() throws Exception {
        mensajeInicio("test Vender Patinete Cuando No Hay Stock");
        Tienda miTienda = new Tienda();
        //miTienda.comprar();
        try{
            miTienda.vender();//reparamos patinete
            fail("Permite vender un patinete cuando no hay stock");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
    /**
     * Test of Vender method, of class Tienda.
     */

    @Test
    public void testVenderPatineteEnStock() throws Exception {
        mensajeInicio("test Vender Patinete Cuando Hay Stock");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        try{
            miTienda.vender();//reparamos patinete
            mensajeOk();
            assertTrue(true);            

        }catch(Exception e){
            fail("No permite vender un patinete cuando hay stock");

        }

    }
    /**
     * Test of Vender method, of class Tienda.
     */    
    @Test
    public void testVenderPatineteCuandoEstaAlquilado() throws Exception {
        mensajeInicio("test Vender Patinete Cuando Esta Alquilado");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        miTienda.alquilar(120);
        try{
            miTienda.vender();//reparamos patinete
            fail("Permite vender un patinete cuando esta alquilado");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
    /**
     * Test of Vender method, of class Tienda.
     */    
    @Test
    public void testVenderPatineteCuandoEstaEnReparacion() throws Exception {
        mensajeInicio("test Vender Patinete Cuando Esta En Reparación");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        miTienda.reparar(20210,223);
        try{
            miTienda.vender();//reparamos patinete
            fail("Permite vender un patinete cuando esta en reparación");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
    /**
     * Test of eliminarLineaArray method, of class Tienda.
     */    
    @Test
    public void testEliminarLineaArrayQueNoExiste() throws Exception {
        mensajeInicio("Test Eliminar Linea Array Que No Existe");
        Tienda miTienda = new Tienda();
        //miTienda.comprar();
        try{
            miTienda.eliminarLineaArray(0);
            fail("Permite eliminar una linea del array que no existe");

        }catch(Exception e){
            mensajeOk();
            assertTrue(true);
        }

    }
    
    /**
     * Test of eliminarLineaArray method, of class Tienda.
     */    
    @Test
    public void testEliminarLineaArrayQueExiste() throws Exception {
        mensajeInicio("Test Eliminar Linea Array Que Existe");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        try{
            miTienda.eliminarLineaArray(0);
            mensajeOk();
            assertTrue(true);

        }catch(Exception e){
            fail("No permite eliminar una linea del array que existe");

        }

    }
    
    /**
     * Test of EstadoPatinetes method, of class Tienda.
     */
    @Test
    public void testEstadoPatinetes() throws Exception {
        mensajeInicio("Test Estado Patinetes");
        Tienda miTienda = new Tienda();
        miTienda.comprar();
        String resultadoEsperado ="Patinete--20210--DISPONIBLE  ";
        String resultado = miTienda.estadoPatinetes();
        if(resultadoEsperado == resultado){           
            mensajeOk();
            assertTrue(true);

        }else{
            fail("devuelve : " + resultado + " pero deberia haber devuelto : " + resultadoEsperado);

        }

    }

    /**
     * Test of Estadisticas method, of class Tienda.
     */
    @Test
    public void testEstadisticas() {

    }
    
}
