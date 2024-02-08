package bytebuddies.repositories;

import bytebuddies.entities.Location;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LocationRepository extends JpaRepository<Location,Integer> {}
