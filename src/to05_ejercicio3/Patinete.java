/*
 * Clase Patinete que contiene:
 * Constantes públicas: PRECIOVENTA (500), PRECIOCOMPRA (350), ALQUILERDIARIO (10), ALQUILERSEMANAL (50)
 * Atributos:
 * codigo de tipo entero. Al adquirir un patinete se le asigna un código numérico de tipo entero. 
 * Esos códigos son únicos y nunca se reutilizan (aunque dicho patinete se venda). Además, una vez asignado a un patinete, no puede cambiar.
 * estado. El patinete se puede encontrar en alguno de estos tres estados: DISPONIBLE, ALQUILADO, ENREPARACION.
 * Constructor: al instanciar un objeto de la clase patinete se debe pasar el código que se le asignará y se pondrá en estado DISPONIBLE.
 * Getters y Setters: únicamente los imprescindibles.
 * Métodos: no necesita otros métodos.
 */
package to05_ejercicio3;
import static to05_ejercicio3.Estado.*;

/**
 *
 * @author Eduardo Jośe Guirado Álvarez
 */
public class Patinete {
    
    private final static int PRECIOVENTA = 500;
    private final static int PRECIOCOMPRA = 350;
    private final static int ALQUILERDIARIO = 10;
    private final static int ALQUILERSEMANAL = 50;
    private final int CODIGOID;
    private Estado EstadoPatinete;
    
    public Patinete(int CODIGOID){
       EstadoPatinete = Estado.DISPONIBLE;
       this.CODIGOID = CODIGOID;
    }
    
    public Estado getEstado(){
        return EstadoPatinete;
    }

    public static int getPRECIOVENTA() {
        return PRECIOVENTA;
    }

    public static int getPRECIOCOMPRA() {
        return PRECIOCOMPRA;
    }

    public int getALQUILERDIARIO() {
        return ALQUILERDIARIO;
    }

    public int getALQUILERSEMANAL() {
        return ALQUILERSEMANAL;
    }

    public void setEstadoPatinete(Estado EstadoPatinete) {
        this.EstadoPatinete = EstadoPatinete;
    }

    public int getCODIGOID() {
        return CODIGOID;
    }
   

    
    
    
    
}
