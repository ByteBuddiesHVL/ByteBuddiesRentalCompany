package bytebuddies.repositories;

import org.springframework.stereotype.Repository;
import bytebuddies.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {}
