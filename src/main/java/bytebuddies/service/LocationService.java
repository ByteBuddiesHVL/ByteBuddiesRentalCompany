package bytebuddies.service;

import bytebuddies.entities.Locations;
import bytebuddies.repositories.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locRepo;

    public List<Locations> getAll() {
        return locRepo.findAll();
    }

	public Locations getById(String tlfNum) {
		return locRepo.findById(tlfNum).orElse(null);
	}

}
