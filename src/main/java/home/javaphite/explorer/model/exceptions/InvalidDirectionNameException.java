package home.javaphite.explorer.model.exceptions;

public class InvalidDirectionNameException extends IllegalArgumentException {

    public InvalidDirectionNameException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    public InvalidDirectionNameException(String errorMessage) {
        super(errorMessage);
    }
}
