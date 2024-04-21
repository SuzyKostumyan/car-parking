package car.parking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("communityId")
    private Long communityId;

    @JsonProperty("isOccupied")
    private boolean isOccupied;

    @JsonProperty("isReserved")
    private boolean isReserved;

    @JsonProperty("reservedBy")
    private Long reservedBy;

    @JsonProperty("reservedFrom")
    private LocalDateTime reservedFrom;

    @JsonProperty("reservedTo")
    private LocalDateTime reservedTo;
}
