package variables;

public class Number extends Variable {
    /**
     * Value of the Variable
     */
    private double value;
    
    /**
     * Initializes a new Variable of the type Number
     * @param name of the Variable
     * @param value of the Variable
     */
    public Number(String name, double value) {
        super(name);
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
}
