package bytebuddies;

import bytebuddies.controller.RegisterUserController;
import bytebuddies.entities.Locations;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TestRegisterUserController {

    @Autowired
    private RegisterUserController regCon;

    @Test
    public void testValidateRegistration() {
        /*
        assertNotNull(regCon.validateUser());
        assertNotNull(regCon.validateUser());
        assertNotNull(regCon.validateUser());
        assertNotNull(regCon.validateUser());
        assertNotNull(regCon.validateUser());
        assertNull(regCon.validateUser());
        */
    }
}
