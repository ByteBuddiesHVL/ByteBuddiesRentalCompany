package bytebuddies.service;

import bytebuddies.entities.Car;
import bytebuddies.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepo;

    public List<Car> getAvailable() {
        return carRepo.findAll().stream().filter(Car::isAvailable).toList();
    }

    public List<Car> getAvailableInGroup(String group) {
        return carRepo.findAll().stream()
                .filter(car -> car.isAvailable() && car.getGroup().equals(group))
                .toList();
    }

    public void saveCar(String regNum, String brand, String color, String group, boolean available) {

    }
}
