package exceptions;

/**
 * Can be thrown when the given input isnt recognized to be any type
 */
public class InvalidTypeException extends Exception {
    /**
     * @param value that isnt any type
     */
    public InvalidTypeException(String value) {
        super("The Type of \'" + value + "\' can't be resolved");
    }
}
