package backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class GraphQLQuery {
    private static final String GRAPHQL_ENDPOINT = "https://staging2.tagaddod.com/graphql";
    private String query;
    private Object variable;

    // Getters
    public String getQuery() {
        return query;
    }

    public Object getVariable() {
        return variable;
    }

    // Setters
    public void setQuery(String query) {
        this.query = query;
    }

    public void setVariable(Object variable) {
        this.variable = variable;
    }

    public Response executeQuery() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String variablesJson = objectMapper.writeValueAsString(variable);
        String payload = "{ \"query\": \"" + query + "\", \"variables\": " + variablesJson + " }";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(GRAPHQL_ENDPOINT)
                .then()
                .extract().response();

        System.out.println(response.asString());
        return response;
    }
}
