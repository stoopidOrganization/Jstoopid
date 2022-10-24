package variables;

/**
 * Variable of type Boolean,
 * Child of Variable
 */
public class Bool extends Variable {
    /**
     * Value of the Variable
     */
    private boolean value;
    
    /**
     * Initializes a new Variable of the type Bool
     * @param name of the Variable
     * @param value of the Variable
     */
    public Bool(String name, boolean value) {
        super(name);
    }
    
    /**
     * @return Value of the Variable
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Sets a new Value for the Variable
     * @param value of the Variable
     */
    public void setValue(boolean value) {
        this.value = value;
    }
}
