package variables;

public class Bool extends Variable {
    private boolean value;
    
    public Bool(String name, boolean value) {
        super(name);
    }
    
    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
