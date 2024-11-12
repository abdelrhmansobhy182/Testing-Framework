package data_helper.requests;

import backend.repositories.AddPhoneRepository;
import backend.repositories.RequestsRepository;
import helpers.DateHelperMethods;
import helpers.GeneralHelperMethods;
import models.requests.BusinessRequest;
import models.requests.CustomerRequest;
import models.User;

import java.io.IOException;

public class RequestsDataHelper {
    private static User customer = new User();
    private static AddPhoneRepository addPhoneRepository = new AddPhoneRepository();
    private static RequestsRepository requestsRepository = new RequestsRepository();

    public static CustomerRequest generateCustomerRequest() throws IOException {
        String customerPhone = GeneralHelperMethods.generatePhoneNumber();
        customer.setPhone(customerPhone);
        customer = addPhoneRepository.addPhone(customer);
        CustomerRequest customerRequest =  new CustomerRequest(
                customer.getRequests().get(0).getId(),
                GeneralHelperMethods.generateAmountNumber(),
                "3638",
                "135",
                DateHelperMethods.getCurrentDate());
        return requestsRepository.createCustomerRequest(customerRequest);

    }

    public static BusinessRequest generateBusinessRequest(User agent) throws IOException {
        BusinessRequest businessRequest = new BusinessRequest(
                "sun",
                "3638",
                GeneralHelperMethods.generateAmountNumber(),
                "12",
                4,
                DateHelperMethods.getCurrentTime(),
                DateHelperMethods.getCurrentDateTime()
        );
        return requestsRepository.createBusinessRequest(agent,businessRequest);
    }
}
