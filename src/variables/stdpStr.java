package variables;

/**
 * <p>
 * Variable of type String
 * <br><br>
 * Child of Variable
 * </p>
 */
public class stdpStr extends Variable {
    /**
     * Value of the Variable
     */
    private String value;
    
    /**
     * Initializes a new Variable of the type String
     * @param name of the Variable
     * @param value of the Variable
     */
    public stdpStr(String name, String value) {
        super(name);
        this.value = value;
    }
    
    /**
     * @return Value of the Variable
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets a new Value for the Variable
     * @param value of the Variable
     */
    public void setValue(String value) {
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
