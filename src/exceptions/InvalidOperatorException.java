package exceptions;

/**
 * can be thrown when the given value isn't an operator
 */
public class InvalidOperatorException extends stpdException {
    /**
     * @param value that isn't an operator
     */
    public InvalidOperatorException(String value) {
        super(value + " isn't an operator");
    }
}
