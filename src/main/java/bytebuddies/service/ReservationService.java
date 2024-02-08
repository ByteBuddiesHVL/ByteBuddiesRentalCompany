package bytebuddies.service;

import bytebuddies.entities.Car;
import bytebuddies.entities.Reservation;
import bytebuddies.entities.User;
import bytebuddies.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservRepo;

    public void reserve(User user, LocalDateTime startDate, LocalDateTime endDate, Car car) {
        Reservation reservation = new Reservation(user, startDate, endDate, car);
        reservRepo.save(reservation);
    }

}
