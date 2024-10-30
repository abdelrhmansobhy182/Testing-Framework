package backend.services;

import models.Query;
import models.User;

public class AddPhoneService {

    public static Query addPhone(User user) {

        Query query = new Query();
        query.setQuery( "mutation addPhone($phone: String!) {" +
                "  webFormAddPhone(phone: $phone) {" +
                "    requests {" +
                "      id" +
                "      status" +
                "      customer {" +
                "        phone" +
                "      }" +
                "    }" +
                "  }" +
                "}");
        query.setVariable(user);
        return query;
    }
}
