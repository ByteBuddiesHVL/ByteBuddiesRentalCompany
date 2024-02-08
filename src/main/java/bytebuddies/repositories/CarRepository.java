package bytebuddies.repositories;

import org.springframework.stereotype.Repository;
import bytebuddies.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CarRepository extends JpaRepository<Car, String> {}
