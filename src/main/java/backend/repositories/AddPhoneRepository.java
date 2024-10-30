package backend.repositories;

import backend.graphql.GraphQLQuery;
import backend.services.AddPhoneService;
import io.restassured.response.Response;
import models.Query;
import models.User;

import java.io.IOException;

public class AddPhoneRepository {

    public User addPhone(User user) throws IOException {
        try {
            Query query = AddPhoneService.addPhone(user);
            Response response = GraphQLQuery.executeQuery(query,null,true,false);
            return GraphQLQuery.parseResponse(response.asString(),"webFormAddPhone",User.class);
        } catch (IOException e) {
            // Handle or log the exception here
            throw new RuntimeException("Failed to addPhone: " + e.getMessage(), e);
        }

    }
}
