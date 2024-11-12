package test_cases.backend.requests;

import backend.repositories.AddPhoneRepository;
import backend.repositories.RequestsRepository;
import enums.RequestStatus;
import helpers.GeneralHelperMethods;
import models.requests.CustomerRequest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class CustomerRequestTests {
    private AddPhoneRepository addPhoneRepository;
    private RequestsRepository requestsRepository;
    private User customer;

    @BeforeMethod
    public void setupData(){
        addPhoneRepository = new AddPhoneRepository();
        requestsRepository =  new RequestsRepository();
        customer = new User();
    }

    @Test
    public void testWebFormRequestByNewCustomer() throws IOException {
        String customerPhone = GeneralHelperMethods.generatePhoneNumber();
        customer.setPhone(customerPhone);
        customer = addPhoneRepository.addPhone(customer);
        CustomerRequest customerRequest = new CustomerRequest(
                customer.getRequests().get(0).getId(),
                GeneralHelperMethods.generateAmountNumber(),
                "3638",
                "135",
                GeneralHelperMethods.getCurrentDate());
        customerRequest = requestsRepository.createCustomerRequest(customerRequest);
        Assert.assertEquals(customerRequest.getStatus(), RequestStatus.DISPATCHED);
        Assert.assertTrue(customerPhone.contains(customerRequest.getCustomer().getPhone()));
    }
}
