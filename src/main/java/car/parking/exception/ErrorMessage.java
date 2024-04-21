package car.parking.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    APPLICATION_ERROR("Car parking service exception", 9000),
    BAD_REQUEST("Bad request", 9001),
    NOT_FOUND("Not found", 9002);

    private final String message;
    private final Integer code;

    ErrorMessage(final String message, final Integer code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("Code: %d, Message: %s", code, message);
    }
}