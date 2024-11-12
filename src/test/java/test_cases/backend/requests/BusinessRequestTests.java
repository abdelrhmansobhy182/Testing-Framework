package test_cases.backend.requests;

import backend.repositories.LoginRepository;
import backend.repositories.RequestsRepository;
import data_helper.user.UserDataHelper;
import helpers.DateHelperMethods;
import helpers.GeneralHelperMethods;
import models.User;
import models.requests.BusinessRequest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BusinessRequestTests {
    private RequestsRepository requestsRepository;
    private LoginRepository loginRepository;
    private User agent;

    @BeforeMethod
    public void setupData(){
        requestsRepository =  new RequestsRepository();
        agent = UserDataHelper.loginWithAdmin();
    }

    @Test
    public void testWebFormRequestByNewCustomer() throws IOException {
        BusinessRequest businessRequest = new BusinessRequest(
                "sun",
                "3638",
                GeneralHelperMethods.generateAmountNumber(),
                "12",
                4,
                DateHelperMethods.getCurrentTime(),
                DateHelperMethods.getCurrentDateTime()
                );
        businessRequest = requestsRepository.createBusinessRequest(agent,businessRequest);
        System.out.println(businessRequest.getId());
        System.out.println(businessRequest.getStatus());
    }

}
