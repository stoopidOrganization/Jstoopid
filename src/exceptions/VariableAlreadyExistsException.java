package exceptions;

public class VariableAlreadyExistsException extends Exception {
    /**
     * @param name that isnt any type
     */
    public VariableAlreadyExistsException(String name) {
        super("A Variable with the name: \'" + name + "\' already exists.");
    }
}
