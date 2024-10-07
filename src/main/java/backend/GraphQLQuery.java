package backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Query;
import models.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GraphQLQuery {
    static Dotenv dotenv = Dotenv.load();
    static String GRAPHQL_ENDPOINT = dotenv.get("GRAPHQL_ENDPOINT");

    public static Response executeQuery(Query query) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("query", query.getQuery());
        bodyMap.put("variables", query.getVariable());

        String jsonBody = objectMapper.writeValueAsString(bodyMap);
        System.out.println("jsonBody : " + jsonBody);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post(GRAPHQL_ENDPOINT)
                .then()
                .extract().response();

        return response;
    }

    public static <T> T parseResponse(String response, String loginKey, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(response)
                .path("data")
                .path(loginKey);
        return objectMapper.treeToValue(node, clazz);
    }
}
