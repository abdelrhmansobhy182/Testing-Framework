package backend.repositories;

import backend.GraphQLQuery;
import backend.services.LoginService;
import io.restassured.response.Response;
import models.Query;
import models.User;

import java.io.IOException;

public class LoginRepository {

    public User login(User user) throws IOException {
        Query query = LoginService.Login(user);
        Response response = GraphQLQuery.executeQuery(query);
        return GraphQLQuery.parseResponse(response.asString(),"login",User.class);
    }
}
