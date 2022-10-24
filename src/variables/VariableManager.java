package variables;

import java.util.ArrayList;

import main.lib;

/**
 * Manages all the Variables,
 * Contains all Variable indexes
 */

public class VariableManager {
    private ArrayList<stdpBool> bools;
    private ArrayList<stdpNum> numbers;
    private ArrayList<stdpString> strings;

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
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return "bool";
        }

        for (stdpNum i : numbers) {
            if(i.getName().equals(name)) return "number";
        }

        for (stdpString i : strings) {
            if(i.getName().equals(name)) return "string";
        }

        return null;
    }

    public stdpBool getBoolVariable(String name) {
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    public stdpNum getNumberVariable(String name) {
        for (stdpNum i : numbers) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    public stdpString getStringVariable(String name) {
        for (stdpString i : strings) {
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
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return true;
        }

        for (stdpNum i : numbers) {
            if(i.getName().equals(name)) return true;
        }

        for (stdpString i : strings) {
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

        if (lib.isBool(value)) {
            this.bools.add(new stdpBool(name, Boolean.parseBoolean(value)));
        } else if (lib.isNumber(value)) {
            this.numbers.add(new stdpNum(name, Double.parseDouble(value)));
        } else {
            this.strings.add(new stdpString(name, value));
        }
    }

    public String getVariableAsString(String name) {
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stdpNum i : numbers) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stdpString i : strings) {
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
