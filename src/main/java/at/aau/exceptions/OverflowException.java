package at.aau.exceptions;

public class OverflowException extends Exception {
    private static final long serialVersionUID = 6830071372702994060L;

    public OverflowException() {
        super();
    }

    public OverflowException(String message) {
        super(message);
    }
}