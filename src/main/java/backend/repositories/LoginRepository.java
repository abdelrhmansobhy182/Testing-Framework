package backend.repositories;

import backend.graphql.GraphQLQuery;
import backend.services.LoginService;
import io.restassured.response.Response;
import models.Query;
import models.User;

import java.io.IOException;

public class LoginRepository {

    public User login(User user) {
        try {
            Query query = LoginService.login(user);
            Response response = GraphQLQuery.executeQuery(query,null,false,false);
            return GraphQLQuery.parseResponse(response.asString(), "login", User.class);
        } catch (IOException e) {
            // Handle or log the exception here
            throw new RuntimeException("Failed to login user: " + e.getMessage(), e);
        }
    }
}
