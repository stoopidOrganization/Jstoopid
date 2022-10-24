package variables;

/**
 * Parent of all Variables,
 * Contains some default code needed in all Variables
 */
public class Variable {
    /**
     * Name of the Variable
     */
    private String name;
    
    /**
     * @param name of the Variable
     */
    public Variable(String name) {
        this.name = name;
    }
    
    /**
     * @return name of the variable
     */
    public String getName() {
        return name;
    }
}