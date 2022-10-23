package variables;

public class Bool extends Variable {
    private boolean value;
    
    public Bool(String name, boolean value) {
        super(name);
        this.value = value;
    }
    
    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
