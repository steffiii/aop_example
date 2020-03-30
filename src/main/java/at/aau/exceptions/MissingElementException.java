package at.aau.exceptions;

public class MissingElementException extends Exception {
	private static final long serialVersionUID = 6830071372702994060L;

	public MissingElementException() {
        super();
    }

    public MissingElementException(String message) {
        super(message);
    }
}
