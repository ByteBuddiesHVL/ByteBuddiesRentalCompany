package bytebuddies.service;

import bytebuddies.entities.RentalCompany;
import bytebuddies.repositories.RentalCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalCompService {

    @Autowired
    private RentalCompanyRepository rentRepo;

    public RentalCompany getCompany() {
        return rentRepo.findAll().getFirst();
    }

}
