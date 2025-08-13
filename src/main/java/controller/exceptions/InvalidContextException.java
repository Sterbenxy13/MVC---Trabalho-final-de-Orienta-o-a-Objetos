
package controller.exceptions;

/**
 *
 * @author Sterbenxy13
 */
public class InvalidContextException extends RuntimeException {
    
    public InvalidContextException(String context) {
        System.out.println("Contexto inválido: " + context);
    }
    
}
