package backend.repositories;

import backend.graphql.GraphQLQuery;
import backend.services.RequestsService;
import io.restassured.response.Response;
import models.Query;
import models.User;
import models.requests.BusinessRequest;
import models.requests.CustomerRequest;
import java.io.IOException;

public class RequestsRepository {

    public CustomerRequest createCustomerRequest(CustomerRequest request) throws IOException {
        try {
            Query query = RequestsService.updateRequestWebForm(request);
            Response response = GraphQLQuery.executeQuery(query,null,true,false);
            return GraphQLQuery.parseResponse(response.asString(),"updateRequestWebForm",CustomerRequest.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to updateRequestWebForm: " + e.getMessage(), e);
        }

    }

    public BusinessRequest createBusinessRequest(User agent, BusinessRequest request) throws IOException {
        try {
            Query query = RequestsService.createBusinessRequest(request);
            Response response = GraphQLQuery.executeQuery(query,agent.getJwtToken(),true,false);
            return GraphQLQuery.parseResponse(response.asString(),"createBuisnessRequest",BusinessRequest.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to createBusinessRequest: " + e.getMessage(), e);
        }

    }
}
