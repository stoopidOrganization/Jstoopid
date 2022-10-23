package variables;

public class Number extends Variable {
    private double value;
    
    public Number(String name, double value) {
        super(name);
    }
    
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
