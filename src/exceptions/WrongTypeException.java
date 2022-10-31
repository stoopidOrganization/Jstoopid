package exceptions;

/**
 * Can be thrown when the value thats being assigned to a variable has a different type than the variable
 */
public class WrongTypeException extends Exception {
    /**
     * @param value thats being assigned
     * @param varName name of the variable
     * @param valueType type of the variable
     * @param varType name of the variable
     */
    public WrongTypeException(String value, String varName, String valueType, String varType) {
        super("Variable \'" + varName + "\' is of type \'" + varType + "\' but the given value \'" + value + "\' has the type \'" + valueType + "\'!");
    }
}
