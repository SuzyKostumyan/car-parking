package car.parking.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

@Getter
public class NotFound extends ApiException {

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
    private final Map<Object, Object> payload;

    public NotFound(final String message) {
        this.code = ErrorMessage.NOT_FOUND.getCode();
        this.message = message;
        this.httpStatus = HttpStatus.NOT_FOUND;
        this.payload = Collections.emptyMap();
    }

    @Override
    public String toString() {
        return "NotFound{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                ", payload=" + payload +
                '}';
    }
}