package car.parking.service;

import car.parking.dto.ReservationRequest;
import car.parking.model.ParkingSpotResponse;

import java.util.List;

public interface ParkingSpotService {

    /**
     * Create parking spots in community
     */
    ParkingSpotResponse createParkingSpot(final Long communityRequest);

    /**
     * Get all available parking spots in community
     */
    List<ParkingSpotResponse> getAvailableSpotsInCommunity(final Long communityId);

    /**
     * Reserve a parking spot
     */
    ParkingSpotResponse reserveSpot(final Long id, final ReservationRequest reservationRequest);

    /**
     * Park a car on a parking spot
     */
    ParkingSpotResponse parkCar(final Long spotId, final Long userId);

    /**
     * Book a parking spot on the spot
     */
    ParkingSpotResponse bookOnTheSpot(final Long userId, final Long communityId);

    /**
     * Release a parking spot
     */
    ParkingSpotResponse releaseSpot(final Long spotId, final Long userId);
}