package exceptions;

/**
 * Can be thrown when the given keyword is invalid
 */
public class InvalidKeywordException extends Exception {
    /**
     * @param keyword that isnt recognized
     */
    public InvalidKeywordException(String keyword) {
        super("Keyword \'" + keyword + "\' doesn't exist.");
    }
}
