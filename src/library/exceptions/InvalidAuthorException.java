package library.exceptions;

public class InvalidAuthorException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidAuthorException(String message) {
        super(message);
    }
}
