package car.parking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;
}
