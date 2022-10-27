package main;

/**
 * <p>
 *  Contains some Standart functions used all over the Project
 *  <br><br>
 *  Methods here should be static
 *  </p>
 */
public class lib {
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
        if(str == "true" || str == "false") return true;;
        
        return false;
    }

    public static boolean isString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) return true;

        return false;
    }
}
