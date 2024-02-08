package bytebuddies.repositories;

import bytebuddies.entities.RentalCompany;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCompanyRepository extends JpaRepository<RentalCompany, String> {}
