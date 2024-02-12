package bytebuddies;

import bytebuddies.controller.HandInController;
import bytebuddies.entities.Reservations;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestHandInController {

    @Autowired
    private HandInController hCon;

    @Test
    public void testValidateReservation() {

        assertNotNull(hCon.validateReservation(null));

        Reservations reserv = new Reservations();
        reserv.setStartDate(LocalDateTime.of(LocalDateTime.now().getYear() + 1,1,1,0,0));
        assertNotNull(hCon.validateReservation(reserv));

        reserv.setStartDate(LocalDateTime.of(LocalDateTime.now().getYear() - 1,1,1,0,0));
        assertNull(hCon.validateReservation(reserv));

    }

}
