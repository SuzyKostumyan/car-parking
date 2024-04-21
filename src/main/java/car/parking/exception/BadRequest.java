package car.parking.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

@Getter
public class BadRequest extends ApiException {

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
    private final Map<Object, Object> payload;

    public BadRequest(final String message) {
        this.code = ErrorMessage.BAD_REQUEST.getCode();
        this.message = message;
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.payload = Collections.emptyMap();
    }

    @Override
    public String toString() {
        return "BadRequest{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                ", payload=" + payload +
                '}';
    }
}