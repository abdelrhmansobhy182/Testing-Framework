package test_cases.backend.requests;

import backend.repositories.AddPhoneRepository;
import backend.repositories.RequestsRepository;
import enums.RequestStatus;
import helpers.HelperMethods;
import models.Request;
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
        String customerPhone = HelperMethods.generatePhoneNumber();
        customer.setPhone(customerPhone);
        customer = addPhoneRepository.addPhone(customer);
        Request customerRequest = new Request(
                customer.getRequests().get(0).getId(),
                (float) HelperMethods.generateAmountNumber(),
                "3638",
                "135",
                HelperMethods.getCurrentDate());
        customerRequest = requestsRepository.updateRequestWebForm(customerRequest);
        Assert.assertEquals(customerRequest.getStatus(), RequestStatus.DISPATCHED);
        Assert.assertTrue(customerPhone.contains(customerRequest.getCustomer().getPhone()));
    }
}
