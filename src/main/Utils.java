package main;

import exceptions.stpdException;

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

    /**
     * Gets the value of a given input
     * <br><br>
     * Solves Equasions, resolves variables
     * @param input
     * @return solved value
     * @throws stpdException
     */
    public static String getValue(String input) throws stpdException {
        if (isString(input)) return input;
        else if (isBool(input)) return input;
        else return String.valueOf(stpdMath.solveEquasion(input));
    }

    /**
     * Combines an Array of Strings into one String
     * @param args full array of strings
     * @param start of the combination
     * @param end of the combination
     * @return combined array as String
     */
    public static String combineArgs(String[] args, int start, int end) {
        String result = "";

        for (int i = start; i < args.length || i < end; i++) {
            result += args[i];
        }

        return result;
    }

    /**
     * Combines an Array of Strings into one String
     * @param args full array of strings
     * @param start of the combination
     * @return combined array as String
     */
    public static String combineArgs(String[] args, int start) {
        String result = "";

        for (int i = start; i < args.length; i++) {
            result += args[i];
        }

        return result;
    }
}
