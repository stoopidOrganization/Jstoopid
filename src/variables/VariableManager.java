package variables;

import java.util.ArrayList;

import main.lib;

/**
 * Manages all the Variables,
 * Contains all Variable indexes
 */

public class VariableManager {
    private ArrayList<Bool> bools;
    private ArrayList<Number> numbers;
    private ArrayList<vString> strings;

    /**
     * Initializes the Lists for the global Variables
     */
    public VariableManager() {
        this.bools = new ArrayList<>();
        this.numbers = new ArrayList<>();
        this.strings = new ArrayList<>();
    }

    public String getType(String value) {
        if (lib.isBool(value)) {
            return "boolean";
        } else if (lib.isNumber(value)) {
            return "number";
        } else {
            return "string";
        }
    }

    public String getVariableType(String name) {
        for (Bool i : bools) {
            if(i.getName().equals(name)) return "bool";
        }

        for (Number i : numbers) {
            if(i.getName().equals(name)) return "number";
        }

        for (vString i : strings) {
            if(i.getName().equals(name)) return "string";
        }

        return null;
    }

    public Bool getBoolVariable(String name) {
        for (Bool i : bools) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    public Number getNumberVariable(String name) {
        for (Number i : numbers) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    public vString getStringVariable(String name) {
        for (vString i : strings) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    /**
     * Gets the Variable as an Object
     * @param name of the Variable
     * @return Variable as Object
     */
    public boolean isVariable(String name) {
        for (Bool i : bools) {
            if(i.getName().equals(name)) return true;
        }

        for (Number i : numbers) {
            if(i.getName().equals(name)) return true;
        }

        for (vString i : strings) {
            if(i.getName().equals(name)) return true;
        }

        return false;
    }

    /**
     * Creates a new Variable
     * @param name of the Variable
     * @param value of the Variable
     */
    public void newVariable(String name, String value) {
        if (getStringVariable(name) != null || getNumberVariable(name) != null || getBoolVariable(name) != null) return;

        if (lib.isNumber(value)) {
            this.numbers.add(new Number(name, Double.parseDouble(value)));
        } else if (lib.isNumber(value)) {
            this.bools.add(new Bool(name, Boolean.parseBoolean(value)));
        } else {
            this.strings.add(new vString(name, value));
        }
    }

    public String getVariableAsString(String name) {
        for (Bool i : bools) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (Number i : numbers) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (vString i : strings) {
            if(i.getName().equals(name)) return i.toString();
        }

        return null;
    }

    public void changeVariable(String name, String value) {
        switch (getType(value)) {
            case "bool":
                getBoolVariable(name).setValue(Boolean.parseBoolean(value));
                break;

            case "number":
                getNumberVariable(name).setValue(Double.parseDouble(value));
                break;

            case "string":
                getStringVariable(name).setValue(value);
                break;
        
            default:
                break;
        }
    }
}
