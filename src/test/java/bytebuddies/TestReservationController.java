package bytebuddies;

import bytebuddies.controller.ReservationController;
import bytebuddies.entities.Cars;
import bytebuddies.entities.Locations;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TestReservationController {

    @Autowired
    private ReservationController reservCon;

    @Test
    public void testValidateReservation() {
        /*
        assertNotNull(regCon.validateCar(null,"Volvo","Grå","A",123,null));
        assertNotNull(regCon.validateCar(null,"BMW","Grå","A",123, new Locations()));
        assertNotNull(regCon.validateCar(new Cars(),"Skoda","Grå","A",123, new Locations()));
        assertNotNull(regCon.validateCar(null,"Skoda","Grå","A",123, new Locations()));
        assertNotNull(regCon.validateCar(null,"Skoda","Grå","F",123, new Locations()));
        assertNotNull(regCon.validateCar(null,"Skoda","A","A",123, new Locations()));
        assertNotNull(regCon.validateCar(null,"Skoda","Grå","A",-1, new Locations()));
        assertNotNull(regCon.validateCar(null,"S","Grå","A",123, new Locations()));
        assertNull(regCon.validateCar(null,"Skoda","Grå","A",123, new Locations()));
        */
    }
}
