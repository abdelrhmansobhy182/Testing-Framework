package backend.repositories;

import backend.GraphQLQuery;
import backend.models.User;
import backend.services.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.io.IOException;

public class LoginRepository {
    public User login(User user) throws IOException {
        GraphQLQuery graphQLQuery = LoginService.LoginMutation(user);
        Response response = graphQLQuery.executeQuery();
        return getActualResponse(response.asString());
    }

    public User getActualResponse(String response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse the "data.login" field into a LoginResponse object
        User loginResponse = objectMapper
                .readTree(response)  // Parse the JSON string to a JSON tree
                .path("data")            // Navigate to the "data" node
                .path("login")           // Navigate to the "login" node
                .traverse(objectMapper)  // Prepare for deserialization
                .readValueAs(User.class);  // Deserialize to LoginResponse

        return loginResponse;
    }
}
