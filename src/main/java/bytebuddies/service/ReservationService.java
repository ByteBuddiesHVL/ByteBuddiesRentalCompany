package bytebuddies.service;

import bytebuddies.entities.Cars;
import bytebuddies.entities.Locations;
import bytebuddies.entities.Reservations;
import bytebuddies.entities.Users;
import bytebuddies.repositories.CarRepository;
import bytebuddies.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservRepo;

    @Autowired
    CarRepository carRepo;

    public void reserve(Users user, String cardNumber, String cardCode, boolean paid, int amount, LocalDateTime startDate, LocalDateTime endDate, Cars car, Locations location) {
        Reservations reservations = new Reservations(user, cardNumber, cardCode, paid, amount, startDate, endDate, car, location);
        car.getReservations().add(reservations);
        reservRepo.save(reservations);
    }

    public List<Reservations> getReservationsBefore() {
        LocalDateTime now = LocalDateTime.now();
        return reservRepo.findAll().stream()
                .filter(r -> !r.getPaid())
                .filter(res -> res.getStartDate().isBefore(now))
                .toList();
    }

    public void handIn(Reservations reservation) {
        reservation.setPaid(true);
        Cars car = reservation.getCar();
        car.setLocation(reservation.getEndLocation());
        reservRepo.save(reservation);
        carRepo.save(car);
    }

    public Reservations getById(Integer id) {
        return reservRepo.findById(id).orElse(null);
    }
}
