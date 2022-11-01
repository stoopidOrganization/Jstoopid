package exceptions;

/**
 * can be thrown when the given value isn't an operator
 */
public class InvalidOperatorException extends Exception {
    /**
     * @param value that isn't an operator
     */
    public InvalidOperatorException(String value) {
        super(value + " isn't an operator");
    }
}
