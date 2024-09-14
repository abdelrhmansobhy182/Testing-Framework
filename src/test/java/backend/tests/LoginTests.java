package backend.tests;

import backend.models.User;
import backend.repositories.LoginRepository;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests {
    @Test
    public void testLogin() throws IOException {
        User user = new User("PHONE","COLLECTOR","01282222222","123456");
        LoginRepository loginRepository = new LoginRepository();
        User user1 = loginRepository.login(user);
        System.out.println(user1.getId());
        System.out.println(user1.getJwtToken());
    }
}
