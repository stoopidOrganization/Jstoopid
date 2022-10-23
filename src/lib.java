public class lib {
    /**
     * @param str string to check
     * @return if string is a number
     */
    public static boolean isNumber(String str) {
        boolean isNumber;

        try {
            Double.parseDouble(str);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }

        return isNumber;
    }

    /**
     * @param str string to check
     * @return if string is a boolean
     */
    public static boolean isBool(String str) {
        boolean isBool = false;

        if(str == "true" || str == "false") isBool = true;
        
        return isBool;
    }
}
