package bytebuddies.repositories;

import bytebuddies.entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationRepository extends JpaRepository<Reservations, Integer> {}
