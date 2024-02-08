package bytebuddies.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "rentalcomp")
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    @ManyToOne
    @JoinColumn(name = "tlfNum")
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToOne
    @JoinColumn(name = "regNum")
    private Car car;

    public Reservation(User user, LocalDateTime startDate, LocalDateTime endDate, Car car) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
    }

    public Reservation() {}
}
