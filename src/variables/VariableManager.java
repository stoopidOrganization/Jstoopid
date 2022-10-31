package variables;

import java.util.ArrayList;

import exceptions.InvalidTypeException;
import exceptions.VariableAlreadyExistsException;
import exceptions.VariableNotFoundException;
import exceptions.WrongTypeException;
import main.lib;

/**
 * <p>
 * Manages all the Variables
 * <br><br>
 * Contains all Variable indexes
 * </p>
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

    /**
     * <p>Get Type of a given Value</p>
     * <ul>
     *     <li>Can Be:<br>
     *         <ul>
     *             <li>bool</li>
     *             <li>num</li>
     *             <li>str</li>
     *         </ul>
     *     </li>
     * </ul>
     * @param value
     * @return type of value
     */
    public String getType(String value) throws InvalidTypeException {
        if (lib.isBool(value)) {
            return "boolean";
        } else if (lib.isNumber(value)) {
            return "num";
        } else if (lib.isString(value)) {
            return "str";
        } else {
            throw new InvalidTypeException(value);
        }
    }

    /**
     * <p>Get Type of a Variable by given Name</p>
     * <ul>
     *     <li>Can Be:<br>
     *         <ul>
     *             <li>bool</li>
     *             <li>num</li>
     *             <li>str</li>
     *         </ul>
     *     </li>
     * </ul>
     * @param name of the Variable
     * @return type of Variable
     */
    public String getVariableType(String name) throws VariableNotFoundException {
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return "bool";
        }

        for (stdpNum i : nums) {
            if(i.getName().equals(name)) return "number";
        }

        for (stdpStr i : strs) {
            if(i.getName().equals(name)) return "string";
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * Get the value of a Variable with type bool
     * @param name of the Variable
     * @return value of the Variable
     */
    public stdpBool getBoolVariable(String name) throws VariableNotFoundException {
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return i;
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * Get the value of a Variable with type num
     * @param name of the Variable
     * @return value of the Variable
     */
    public stdpNum getNumVariable(String name) throws VariableNotFoundException {
        for (stdpNum i : nums) {
            if(i.getName().equals(name)) return i;
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * Get the value of a Variable with type str
     * @param name of the Variable
     * @return value of the Variable
     */
    public stdpStr getStrVariable(String name) throws VariableNotFoundException {
        for (stdpStr i : strs) {
            if(i.getName().equals(name)) return i;
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * @param name of the Variable
     * @return if variable exists
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
     * @throws Exception
     */
    public void newVariable(String name, String value) throws InvalidTypeException, VariableNotFoundException, VariableAlreadyExistsException {
        if(isVariable(name)) throw new VariableAlreadyExistsException(name);

        if (lib.isBool(value)) {
            this.bools.add(new stdpBool(name, Boolean.parseBoolean(value)));
        } else if (lib.isNumber(value)) {
            this.nums.add(new stdpNum(name, Double.parseDouble(value)));
        } else if (lib.isString(value)) {
            this.strs.add(new stdpStr(name, value));
        } else {
            throw new InvalidTypeException(value);
        }
    }

    /**
     * Returns Value of any Variable as a String
     * @param name of the Variable
     * @return value of the Variable as String
     */
    public String getVariableAsString(String name) throws VariableNotFoundException {
        for (stdpBool i : bools) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stdpNum i : nums) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stdpStr i : strs) {
            if(i.getName().equals(name)) return i.toString();
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * Changes the Value of amy Variable
     * @param name of the variable
     * @param value that the variable should be set to
     */
    public void changeVariable(String name, String value) throws InvalidTypeException, WrongTypeException, VariableNotFoundException {
        if(getType(value) != getVariableType(name)) throw new WrongTypeException(value, name, getType(value), getVariableType(name));

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
        }
    }
}
