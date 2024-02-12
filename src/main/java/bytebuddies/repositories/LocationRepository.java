package bytebuddies.repositories;

import bytebuddies.entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LocationRepository extends JpaRepository<Locations, String> {}
