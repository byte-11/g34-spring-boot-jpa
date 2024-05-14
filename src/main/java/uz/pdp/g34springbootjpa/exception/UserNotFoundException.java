package uz.pdp.g34springbootjpa.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String by, Object value) {
        super(String.format("User not found by %s [%s]", by, value));
    }
}
