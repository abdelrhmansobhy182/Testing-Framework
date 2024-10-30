package test_cases.backend.login;

import enums.AuthTypes;
import models.User;
import backend.repositories.LoginRepository;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests {
    @Test
    public void testLoginWithValidData() throws IOException {
        User user = new User(AuthTypes.PHONE,"01282222222","123456");
        LoginRepository loginRepository = new LoginRepository();
        User user1 = loginRepository.login(user);
        System.out.println(user1.getJwtToken());
        System.out.println(user1.getRoles().get(1).getName());

    }
}
