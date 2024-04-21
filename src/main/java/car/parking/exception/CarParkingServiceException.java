package car.parking.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class CarParkingServiceException extends ApiException {

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;
    private final Map<Object, Object> payload;

    public CarParkingServiceException(final Map<Object, Object> payload) {
        this.code = ErrorMessage.APPLICATION_ERROR.getCode();
        this.message = ErrorMessage.APPLICATION_ERROR.getMessage();
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.payload = payload;
    }

    public static CarParkingServiceException from(final Map<Object, Object> payload) {
        return new CarParkingServiceException(payload);
    }

    @Override
    public String toString() {
        return "CarParkingServiceException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", payload=" + payload +
                ", httpStatus=" + httpStatus +
                '}';
    }
}