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
public class PatineteTest {
    
    public PatineteTest() {
    }

    /**
     * Test of getEstado method, of class Patinete.
     */
    @Test
    public void testGetEstado() {
        System.out.println("test getEstado");
        Patinete patineteTest = new Patinete(112);
        patineteTest.setEstadoPatinete(Estado.ALQUILADO);
        Estado resultadoEsperado = Estado.ALQUILADO;
        Estado resultado = patineteTest.getEstado();
        if(resultadoEsperado.equals(resultado)){
            assertTrue(true);
        }else{
        fail("No devuelve el estado esperado");
        }
    }

    /**
     * Test of getPRECIOVENTA method, of class Patinete.
     */
    @Test
    public void testGetPRECIOVENTA() {
        System.out.println("test GetPRECIOVENTA");
        int resultadoEsperado = 500;
        int resultado = Patinete.getPRECIOVENTA();
        if(resultadoEsperado == resultado){
            assertTrue(true);
        }else{
        fail("No devuelve el precio de venta esperado ");
        }        
    }

    /**
     * Test of getPRECIOCOMPRA method, of class Patinete.
     */
    @Test
    public void testGetPRECIOCOMPRA() {
        System.out.println("test GetPRECIOCOMPR");
        int resultadoEsperado = 350;
        int resultado = Patinete.getPRECIOCOMPRA();
        if(resultadoEsperado == resultado){
            assertTrue(true);
        }else{
        fail("No devuelve el precio de compra esperado ");
        }    
    }

    /**
     * Test of getALQUILERDIARIO method, of class Patinete.
     */
    @Test
    public void testGetALQUILERDIARIO() {
        System.out.println("test GetALQUILERDIARIO");
        Patinete patineteTest = new Patinete(112);
        int resultadoEsperado = 10;
        int resultado = patineteTest.getALQUILERDIARIO();
        if(resultadoEsperado == resultado){
            assertTrue(true);
        }else{
        fail("No devuelve el alquiler diario esperado");
        }   
    }

    /**
     * Test of getALQUILERSEMANAL method, of class Patinete.
     */
    @Test
    public void testGetALQUILERSEMANAL() {
        System.out.println("test GetALQUILERDIARIO");
        Patinete patineteTest = new Patinete(112);
        int resultadoEsperado = 50;
        int resultado = patineteTest.getALQUILERSEMANAL();
        if(resultadoEsperado == resultado){
            assertTrue(true);
        }else{
        fail("No devuelve el alquiler semanal esperado");
        }  
    }

    /**
     * Test of setEstadoPatinete method, of class Patinete.
     */
    @Test
    public void testSetEstadoPatinete() {
        System.out.println("test SetEstadoPatinete");
        Patinete patineteTest = new Patinete(112);
        Estado resultadoEsperado = Estado.ENREPARACION;
        patineteTest.setEstadoPatinete(Estado.ENREPARACION);
        Estado resultado = patineteTest.getEstado();
        if(resultadoEsperado.equals(resultado)){
            assertTrue(true);
        }else{
        fail("No devuelve el estado esperado");
        }
    }

    /**
     * Test of getCODIGOID method, of class Patinete.
     */
    @Test
    public void testGetCODIGOID() {
        System.out.println("test GetCODIGOID");
        Patinete patineteTest = new Patinete(1132);
        int resultadoEsperado = 1132;
        int resultado = patineteTest.getCODIGOID();
        if(resultadoEsperado == resultado){
            assertTrue(true);
        }else{
        fail("No devuelve el CODIGOID  esperado");
        }  
    }
    
}
