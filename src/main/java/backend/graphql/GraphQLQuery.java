package backend.graphql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Query;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GraphQLQuery {
    static Dotenv dotenv = Dotenv.load();
    static String GRAPHQL_ENDPOINT = dotenv.get("GRAPHQL_ENDPOINT");

    public static Response executeQuery(Query query, String bearerToken, Boolean webFormRequest, Boolean forScaleApp) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("query", query.getQuery());
        bodyMap.put("variables", query.getVariable());

        String jsonBody = objectMapper.writeValueAsString(bodyMap);
        System.out.println("jsonBody: " + jsonBody);

        // Prepare the RestAssured request
        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "application/json");

        // Add headers only if they are not null
        if (webFormRequest) {
            request.header("webform-api-key", dotenv.get("WEBFORM_REQUEST_KEY"));
        }
        if (bearerToken != null) {
            request.header("Authorization", "Bearer " + bearerToken);
        }
        if (forScaleApp) {
            request.header("for-scale-app", true);
        }

        // Execute the request
        Response response = request.body(jsonBody)
                .when()
                .post(GRAPHQL_ENDPOINT)
                .then()
                .extract().response();

        System.out.println(response.asString());
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
