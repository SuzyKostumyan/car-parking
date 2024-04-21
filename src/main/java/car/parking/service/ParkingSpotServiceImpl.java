package car.parking.service;

import car.parking.domain.Community;
import car.parking.domain.ParkingSpot;
import car.parking.dto.ReservationRequest;
import car.parking.exception.BadRequest;
import car.parking.exception.NotFound;
import car.parking.model.CommunityResponse;
import car.parking.model.ParkingSpotResponse;
import car.parking.repository.ParkingSpotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParkingSpotServiceImpl implements ParkingSpotService {

    private final CommunityService communityService;

    private final ParkingSpotRepository parkingSpotRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public ParkingSpotResponse createParkingSpot(final Long communityId) {
        log.info("Creating parking spot for community: {}", communityId);

        CommunityResponse community = communityService.getCommunityById(communityId);

        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setCommunity(modelMapper.map(community, Community.class));

        return modelMapper.map(parkingSpotRepository.save(parkingSpot), ParkingSpotResponse.class);
    }

    @Override
    public List<ParkingSpotResponse> getAvailableSpotsInCommunity(final Long communityId) {
        log.info("Retrieving available spots for community Id: {}", communityId);

        List<ParkingSpot> parkingSpots = communityId != null ? parkingSpotRepository.findByCommunityIdAndIsOccupiedFalse(communityId) :
                this.getAllAvailableSpots();

        return parkingSpots.stream()
                .map(parkingSpot -> modelMapper.map(parkingSpot, ParkingSpotResponse.class))
                .collect(Collectors.toList());
    }

    private List<ParkingSpot> getAllAvailableSpots() {
        return parkingSpotRepository.findByIsOccupiedFalse();
    }

    @Override
    @Transactional
    public ParkingSpotResponse reserveSpot(final Long id, final ReservationRequest reservationRequest) {
        log.info("Reserving spot: {} for community: {}", id, reservationRequest.getCommunityId());

        ParkingSpot spot = parkingSpotRepository.findByIdAndCommunityIdAndIsOccupiedFalse(id, reservationRequest.getCommunityId())
                .orElseThrow(() -> new NotFound("Spot not found."));

        spot.reserve(reservationRequest.getReservedBy(), reservationRequest.getDateFrom(), reservationRequest.getDateTo());

        return modelMapper.map(parkingSpotRepository.save(spot), ParkingSpotResponse.class);
    }

    @Override
    @Transactional
    public ParkingSpotResponse parkCar(final Long id, final Long userId) {
        log.info("Parking car in spot: {} by user: {}", id, userId);

        ParkingSpot spot = parkingSpotRepository.findByIdAndReservedByAndIsOccupiedFalse(id, userId)
                .orElseThrow(() -> new NotFound("Spot not found."));

        spot.setOccupied(true);

        return modelMapper.map(parkingSpotRepository.save(spot), ParkingSpotResponse.class);
    }

    @Override
    @Transactional
    public ParkingSpotResponse bookOnTheSpot(final Long userId, final Long communityId) {
        log.info("Booking on the spot for user: {} in community: {}", userId, communityId);

        ParkingSpot spot = parkingSpotRepository.findByCommunityIdAndIsOccupiedFalse(communityId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new BadRequest("No available spots."));

        spot.setOccupied(true);
        spot.setReservedBy(userId);
        spot.setReservedFrom(LocalDateTime.now());

        return modelMapper.map(parkingSpotRepository.save(spot), ParkingSpotResponse.class);
    }

    @Override
    @Transactional
    public ParkingSpotResponse releaseSpot(final Long spotId, final Long userId) {
        log.info("Releasing spot: {} by user: {}", spotId, userId);

        ParkingSpot spot = parkingSpotRepository.findByIdAndReservedBy(spotId, userId)
                .orElseThrow(() -> new NotFound("Spot not found."));

        spot.cleanReservationDetails();

        return modelMapper.map(parkingSpotRepository.save(spot), ParkingSpotResponse.class);
    }
}