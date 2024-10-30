package backend.repositories;

import backend.graphql.GraphQLQuery;
import backend.services.RequestsService;
import io.restassured.response.Response;
import models.Query;
import models.Request;
import java.io.IOException;

public class RequestsRepository {

    public Request updateRequestWebForm(Request request) throws IOException {
        try {
            Query query = RequestsService.updateRequestWebForm(request);
            Response response = GraphQLQuery.executeQuery(query,null,true,false);
            return GraphQLQuery.parseResponse(response.asString(),"updateRequestWebForm",Request.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to updateRequestWebForm: " + e.getMessage(), e);
        }

    }
}
