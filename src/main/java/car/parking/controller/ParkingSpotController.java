package car.parking.controller;

import car.parking.dto.ReservationRequest;
import car.parking.model.ParkingSpotResponse;
import car.parking.service.ParkingSpotService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/parking-spots")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    @PostMapping
    public ResponseEntity<ParkingSpotResponse> createParkingSpot(final @RequestParam Long communityId) {

        return ResponseEntity.ok(parkingSpotService.createParkingSpot(communityId));
    }

    @GetMapping("/available")
    public ResponseEntity<List<ParkingSpotResponse>> getAvailableSpots(final @RequestParam(required = false) Long communityId) {

        return ResponseEntity.ok(parkingSpotService.getAvailableSpotsInCommunity(communityId));
    }

    @PostMapping("/{id}/reserve")
    public ResponseEntity<ParkingSpotResponse> reserveSpot(
            final @PathVariable Long id,
            final @RequestBody ReservationRequest reservationRequest
    ) {
        return ResponseEntity.ok(parkingSpotService.reserveSpot(id, reservationRequest));
    }

    @PatchMapping("/{id}/park")
    public ResponseEntity<ParkingSpotResponse> parkCar(
            final @PathVariable Long id,
            final @RequestParam Long userId
    ) {

        return ResponseEntity.ok(parkingSpotService.parkCar(id, userId));
    }

    @PostMapping("/book-on-the-spot")
    public ResponseEntity<ParkingSpotResponse> bookOnTheSpot(
            final @RequestParam Long userId,
            final @RequestParam Long communityId
    ) {

        return ResponseEntity.ok(parkingSpotService.bookOnTheSpot(userId, communityId));
    }

    @PatchMapping("/{id}/release")
    public ResponseEntity<ParkingSpotResponse> releaseSpot(
            final @PathVariable Long id,
            final @RequestParam Long userId
    ) {

        return ResponseEntity.ok(parkingSpotService.releaseSpot(id, userId));
    }
}