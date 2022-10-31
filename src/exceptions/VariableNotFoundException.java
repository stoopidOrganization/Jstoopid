package exceptions;

/**
 * Can be thrown when a variable with the given name can not be found
 */
public class VariableNotFoundException extends Exception {
    /**
     * @param name of the Variable
     */
    public VariableNotFoundException(String name) {
        super("Variable with name \'" + name + "\' can't be found.");
    }
}
