package main;

import exceptions.InvalidTypeException;
import exceptions.VariableNotFoundException;

/**
 * <p>
 *  Contains some Standart functions used all over the Project
 *  <br><br>
 *  Methods here should be static
 *  </p>
 */
public class Utils {
    /**
     * @param str string to check
     * @return if string is a number
     */
    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param str string to check
     * @return if string is a boolean
     */
    public static boolean isBool(String str) {
        if(str.equals("true") || str.equals("false")) return true;;
        
        return false;
    }

    /**
     * @param str string to check
     * @return if string is a string
     */
    public static boolean isString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) return true;

        return false;
    }

    public static String getValue(String value) throws InvalidTypeException, VariableNotFoundException {
        String result = null;

        if (isNumber(value)) result = value;
        else if (isBool(value)) result = value;
        else if (isString(value)) result = value;
        else if (Main.varMan.isVariable(value)) result = Main.varMan.getVariableAsString(value);
        else throw new InvalidTypeException(value);

        return result;
    }
}
