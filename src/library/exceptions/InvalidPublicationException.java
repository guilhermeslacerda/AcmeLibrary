package library.exceptions;

public class InvalidPublicationException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPublicationException(String message) {
        super(message);
    }
}
