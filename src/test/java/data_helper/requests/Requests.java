package data_helper.requests;

import backend.repositories.AddPhoneRepository;
import helpers.HelperMethods;
import models.Request;
import models.User;

import java.io.IOException;

public class Requests {
    static User customer = new User();
    static AddPhoneRepository addPhoneRepository = new AddPhoneRepository();

    public static Request generateCustomerRequest() throws IOException {
        String customerPhone = HelperMethods.generatePhoneNumber();
        customer.setPhone(customerPhone);
        customer = addPhoneRepository.addPhone(customer);
        return new Request(
                customer.getRequests().get(0).getId(),
                (float) HelperMethods.generateAmountNumber(),
                "3638",
                "135",
                HelperMethods.getCurrentDate());
    }
}
