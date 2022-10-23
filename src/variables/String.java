package variables;

public class String extends Variable {
    private String value;
    
    public String(String name, double value) {
        super(name);
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
