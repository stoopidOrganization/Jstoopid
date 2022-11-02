package exceptions;

/**
 * Can be thrown when a variable with given name already exists
 */
public class VariableAlreadyExistsException extends stpdException {
    /**
     * @param name of the variable
     */
    public VariableAlreadyExistsException(String name) {
        super("A Variable with the name: \'" + name + "\' already exists.");
    }
}
