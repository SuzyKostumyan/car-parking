package helper;

import car.parking.domain.Community;
import car.parking.domain.ParkingSpot;
import car.parking.model.ParkingSpotResponse;
import lombok.Setter;
import util.RandomValueGenerator;

import java.time.LocalDateTime;

@Setter
public class ParkingSpotBuilder {

    private Long id = RandomValueGenerator.generatePositiveRandomLong();
    private Community community = new CommunityBuilder().build();
    private boolean isOccupied = RandomValueGenerator.generateRandomBoolean();
    private boolean isReserved = RandomValueGenerator.generateRandomBoolean();
    private Long reservedBy = RandomValueGenerator.generatePositiveRandomLong();
    private LocalDateTime reservedFrom = LocalDateTime.now();
    private LocalDateTime reservedTo = LocalDateTime.now();

    public ParkingSpot build() {
        return new ParkingSpot(id, community, isOccupied, isReserved, reservedBy, reservedFrom, reservedTo);
    }

    public ParkingSpotResponse buildParkingSpotResponse() {
        return new ParkingSpotResponse(id, community.getId(), isOccupied, isReserved, reservedBy, reservedFrom, reservedTo);
    }
}