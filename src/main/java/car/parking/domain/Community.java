package car.parking.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "community")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}

