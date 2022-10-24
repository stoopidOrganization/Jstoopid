package variables;

import java.util.ArrayList;

import main.lib;

/**
 * Manages all the Variables,
 * Contains all Variable indexes
 */

public class VariableManager {
    private ArrayList<stdpBool> bools;
    private ArrayList<stdpNum> nums;
    private ArrayList<stdpStr> strs;

    /**
     * Initializes the Lists for the global Variables
     */
    public VariableManager() {
        this.bools = new ArrayList<>();
        this.nums = new ArrayList<>();
        this.strs = new ArrayList<>();
    }

    public String getType(String value) {
        if (lib.isBool(value)) {
            return "boolean";
        } else if (lib.isNumber(value)) {
            return "num";
        } else {
            return "str";
        }
    }

    public String getVariableType(String name) {
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return "bool";
        }

        for (stdpNum i : nums) {
            if(i.getName().equals(name)) return "number";
        }

        for (stdpStr i : strs) {
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

    public stdpNum getNumVariable(String name) {
        for (stdpNum i : nums) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    public stdpStr getStrVariable(String name) {
        for (stdpStr i : strs) {
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

        for (stdpNum i : nums) {
            if(i.getName().equals(name)) return true;
        }

        for (stdpStr i : strs) {
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
        if (getStrVariable(name) != null || getNumVariable(name) != null || getBoolVariable(name) != null) return;

        if (lib.isBool(value)) {
            this.bools.add(new stdpBool(name, Boolean.parseBoolean(value)));
        } else if (lib.isNumber(value)) {
            this.nums.add(new stdpNum(name, Double.parseDouble(value)));
        } else {
            this.strs.add(new stdpStr(name, value));
        }
    }

    public String getVariableAsString(String name) {
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stdpNum i : nums) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stdpStr i : strs) {
            if(i.getName().equals(name)) return i.toString();
        }

        return null;
    }

    public void changeVariable(String name, String value) {
        switch (getType(value)) {
            case "bool":
                getBoolVariable(name).setValue(Boolean.parseBoolean(value));
                break;

            case "num":
                getNumVariable(name).setValue(Double.parseDouble(value));
                break;

            case "str":
                getStrVariable(name).setValue(value);
                break;
        
            default:
                break;
        }
    }
}
