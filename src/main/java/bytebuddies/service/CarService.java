package bytebuddies.service;

import bytebuddies.entities.Cars;
import bytebuddies.entities.Locations;
import bytebuddies.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepo;

    public List<Cars> getAvailableBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return carRepo.findAll().stream().filter(c -> c.isAvailableBetween(startDate, endDate)).toList();
    }

    public List<Cars> getAvailableInGroup(String group, LocalDateTime startDate, LocalDateTime endDate) {
        return carRepo.findAll().stream()
                .filter(cars -> cars.getGroup().equals(group))
                .filter(c -> c.isAvailableBetween(startDate, endDate))
                .toList();
    }

    public Cars getById(String regNum) {
        return carRepo.findById(regNum).orElse(null);
    }

    public void saveCar(String regNum, String brand, String color, String group, int distDriven, Locations locations) {
        carRepo.save(new Cars(regNum, brand, color, group, distDriven, locations));
    }

    public List<Cars> getAvailableAtLocation(String group, Locations location, LocalDateTime startDate, LocalDateTime endDate) {
        return carRepo.findAll().stream()
                .filter(car -> car.getGroup().equals(group))
                .filter(car -> car.getLocationAt(startDate).equals(location))
                .filter(car -> car.isAvailableBetween(startDate, endDate))
                .toList();
    }
}
