package variables;

import java.util.ArrayList;

/**
 * Manages all the Variables,
 * Contains all Variable indexes
 */
public class VariableManager {
    private ArrayList<Bool> bools;
    private ArrayList<Number> numbers;
    private ArrayList<String> strings;

    /**
     * Initializes the Lists for the global Variables
     */
    public VariableManager() {
        this.bools = new ArrayList<>();
        this.numbers = new ArrayList<>();
        this.strings = new ArrayList<>();
    }

    /**
     * Gets the Variable as an Object
     * @param name of the Variable
     * @return Variable as Object
     */
    public Variable getVariable(String name) {
        for (Bool i : bools) {
            if(i.getName().equals(name)) return i;
        }

        for (Number i : numbers) {
            if(i.getName().equals(name)) return i;
        }

        for (String i : strings) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    /**
     * Creates a new Variable
     * @param name of the Variable
     * @param value of the Variable
     */
    public void newVariable(String name, String value) {
    }
}
