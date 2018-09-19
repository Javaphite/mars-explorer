package home.javaphite.explorer.model.exceptions;

public class UnknownObjectIdException extends IllegalArgumentException {

    public UnknownObjectIdException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    public UnknownObjectIdException(String errorMessage) {
        super(errorMessage);
    }

}
