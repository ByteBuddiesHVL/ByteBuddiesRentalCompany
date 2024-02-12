package bytebuddies.repositories;

import org.springframework.stereotype.Repository;
import bytebuddies.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CarRepository extends JpaRepository<Cars, String> {}
