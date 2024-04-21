package car.parking.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "parking_spot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    @Column(name = "is_occupied")
    private boolean isOccupied;

    @Column(name = "is_reserved")
    private boolean isReserved;

    @Column(name = "reserved_by")
    private Long reservedBy;

    @Column(name = "reserved_from")
    private LocalDateTime reservedFrom;

    @Column(name = "reserved_to")
    private LocalDateTime reservedTo;

    public void reserve(Long reservedBy, LocalDateTime from, LocalDateTime to) {
        this.setReserved(true);
        this.setReservedBy(reservedBy);
        this.setReservedFrom(from);
        this.setReservedTo(to);
    }

    public void cleanReservationDetails() {
        this.setReserved(false);
        this.setOccupied(false);
        this.setReservedBy(null);
        this.setReservedFrom(null);
        this.setReservedTo(null);
    }
}
