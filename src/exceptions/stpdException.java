package exceptions;

/**
 * Parent Class for all Exceptions in Stoopid
 */
public class stpdException extends Exception {
    /**
     * @param msg message to be printed
     */
    public stpdException(String msg) {
        super(msg); 
    }
}
