package car.parking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationRequest {

    @JsonProperty("communityId")
    private Long communityId;

    @JsonProperty("reservedBy")
    private Long reservedBy;

    @JsonProperty("dateFrom")
    private LocalDateTime dateFrom;

    @JsonProperty("dateTo")
    private LocalDateTime dateTo;
}
