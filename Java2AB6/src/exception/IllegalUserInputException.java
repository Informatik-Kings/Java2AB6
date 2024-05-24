package exception;
/**
 * Spezialisierte {@link IllegalStateException} zur Anzeige von fehlerfahften
 * Anwendereingaben.
 * 
 * @author M. Faulstich
 *
 */
public class IllegalUserInputException extends IllegalArgumentException {
    
    private static final long serialVersionUID = -8804490117576699909L;

    
    /**
     * Delegiert an {@link IllegalArgumentException#IllegalArgumentException()}.
     */
    public IllegalUserInputException() {
        super();
    }

    /**
     * Delegiert an {@link IllegalArgumentException#IllegalArgumentException(String, Throwable)}.
     */
    public IllegalUserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Delegiert an {@link IllegalArgumentException#IllegalArgumentException(String)}.
     */
    public IllegalUserInputException(String s) {
        super(s);
    }

    /**
     * Delegiert an {@link IllegalArgumentException#IllegalArgumentException(Throwable)}.
     */
    public IllegalUserInputException(Throwable cause) {
        super(cause);
    }


}
