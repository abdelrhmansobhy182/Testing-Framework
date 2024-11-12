package data_helper.user;

import backend.repositories.LoginRepository;
import enums.AuthTypes;
import models.User;

public class UserDataHelper {
    static LoginRepository loginRepository = new LoginRepository();
    public static User loginWithAdmin(){
       User user = new User(AuthTypes.PHONE,"01124542365","12345678");
        return loginRepository.login(user);
    }
}