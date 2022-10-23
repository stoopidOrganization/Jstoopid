package variables;

public class vString extends Variable {
    private String value;
    
    public vString(String name, String value) {
        super(name);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
