package backend.services;

import models.Query;
import models.User;

public class LoginService {

    public static Query login(User user) {

        Query query = new Query();
        query.setQuery( "mutation login(" +
                "  $type: AuthType!" +
                "  $phone: String!" +
                "  $password: String!" +
                ") {" +
                "  login(type: $type, phone: $phone, password: $password) {" +
                "    id" +
                "    phone" +
                "    roles{" +
                "      id" +
                "      name" +
                "    }" +
                "    jwtToken" +
                "  }" +
                "}");
        query.setVariable(user);
        return query;
    }
}
