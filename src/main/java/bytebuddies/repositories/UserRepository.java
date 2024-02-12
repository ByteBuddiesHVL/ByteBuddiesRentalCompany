package bytebuddies.repositories;

import org.springframework.stereotype.Repository;
import bytebuddies.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<Users, String> {}
