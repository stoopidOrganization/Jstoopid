package variables;

import java.util.ArrayList;

import exceptions.InvalidTypeException;
import exceptions.VariableAlreadyExistsException;
import exceptions.VariableNotFoundException;
import exceptions.WrongTypeException;
import main.Utils;

/**
 * <p>
 * Manages all the Variables
 * <br><br>
 * Contains all Variable indexes
 * </p>
 */
public class VariableManager {
    private ArrayList<stpdBool> bools;
    private ArrayList<stpdNum> nums;
    private ArrayList<stpdStr> strs;

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
        if (Utils.isBool(value)) {
            return "boolean";
        } else if (Utils.isNumber(value)) {
            return "num";
        } else if (Utils.isString(value)) {
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
        for (stpdBool i : bools) {
            if(i.getName().equals(name)) return "bool";
        }

        for (stpdNum i : nums) {
            if(i.getName().equals(name)) return "number";
        }

        for (stpdStr i : strs) {
            if(i.getName().equals(name)) return "string";
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * Get the value of a Variable with type bool
     * @param name of the Variable
     * @return value of the Variable
     */
    public stpdBool getBoolVariable(String name) throws VariableNotFoundException {
        for (stpdBool i : bools) {
            if(i.getName().equals(name)) return i;
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * Get the value of a Variable with type num
     * @param name of the Variable
     * @return value of the Variable
     */
    public stpdNum getNumVariable(String name) throws VariableNotFoundException {
        for (stpdNum i : nums) {
            if(i.getName().equals(name)) return i;
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * Get the value of a Variable with type str
     * @param name of the Variable
     * @return value of the Variable
     */
    public stpdStr getStrVariable(String name) throws VariableNotFoundException {
        for (stpdStr i : strs) {
            if(i.getName().equals(name)) return i;
        }

        throw new VariableNotFoundException(name);
    }

    /**
     * @param name of the Variable
     * @return if variable exists
     */
    public boolean isVariable(String name) {
        for (stpdBool i : bools) {
            if(i.getName().equals(name)) return true;
        }

        for (stpdNum i : nums) {
            if(i.getName().equals(name)) return true;
        }

        for (stpdStr i : strs) {
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

        if (Utils.isBool(value)) {
            this.bools.add(new stpdBool(name, Boolean.parseBoolean(value)));
        } else if (Utils.isNumber(value)) {
            this.nums.add(new stpdNum(name, Double.parseDouble(value)));
        } else if (Utils.isString(value)) {
            this.strs.add(new stpdStr(name, value));
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
        for (stpdBool i : bools) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stpdNum i : nums) {
            if(i.getName().equals(name)) return i.toString();
        }

        for (stpdStr i : strs) {
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
