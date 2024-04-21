package car.parking.repository;

import car.parking.domain.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

    List<ParkingSpot> findByIsOccupiedFalse();

    Optional<ParkingSpot> findByIdAndReservedBy(final Long id, final Long userId);

    Optional<ParkingSpot> findByIdAndReservedByAndIsOccupiedFalse(final Long id, final Long communityId);

    List<ParkingSpot> findByCommunityIdAndIsOccupiedFalse(final Long communityId);

    Optional<ParkingSpot> findByIdAndCommunityIdAndIsOccupiedFalse(final Long id, final Long communityId);
}