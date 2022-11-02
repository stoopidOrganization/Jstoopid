package variables;

/**
 * <p>
 * Variable of type Number
 * <br><br>
 * Child of Variable
 * </p>
 */
public class stpdNum extends Variable {
    /**
     * Value of the Variable
     */
    private double value;
    
    /**
     * Initializes a new Variable of the type Number
     * @param name of the Variable
     * @param value of the Variable
     */
    public stpdNum(String name, double value) {
        super(name);
        this.value = value;
    }
    
    /**
     * @return Value of the Variable
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets a new Value for the Variable
     * @param value of the Variable
     */
    public void setValue(double value) {
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
