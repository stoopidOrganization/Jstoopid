package variables;

/**
 * <p>
 * Variable of type Boolean
 * <br><br>
 * Child of Variable
 * </p>
 */
public class stdpBool extends Variable {
    /**
     * Value of the Variable
     */
    private boolean value;
    
    /**
     * Initializes a new Variable of the type Bool
     * @param name of the Variable
     * @param value of the Variable
     */
    public stdpBool(String name, boolean value) {
        super(name);
        this.value = value;
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

    @Override
    /**
     * returns the Value of the Variable as String
     */
    public String toString() {
        return String.valueOf(this.value);
    }
}
