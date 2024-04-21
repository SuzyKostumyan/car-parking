package helper;

import car.parking.domain.Community;
import car.parking.model.CommunityResponse;
import lombok.Setter;
import util.RandomValueGenerator;

@Setter
public class CommunityBuilder {

    private Long id = RandomValueGenerator.generatePositiveRandomLong();
    private String name = RandomValueGenerator.generateRandomString();
    private String address = RandomValueGenerator.generateRandomString();

    public Community build() {
        return new Community(id, name, address);
    }

    public CommunityResponse buildCommunityResponse() {
        return new CommunityResponse(id, name, address);
    }
}