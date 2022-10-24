package variables;

/**
 * <p>
 * Parent of all Variables
 * <br><br>
 * Contains some default code needed in all Variables
 * </p>
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