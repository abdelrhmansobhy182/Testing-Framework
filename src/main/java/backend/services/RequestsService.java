package backend.services;

import models.Query;
import models.Request;
import models.User;

public class RequestsService {

    public static Query updateRequestWebForm(Request request) {

        Query query = new Query();
        query.setQuery( "mutation updateRequestWebForm(" +
                "  $id: ID!" +
                "  $status: UpdateRequestStatus!" +
                "  $amount: Float!" +
                "  $addressId: ID!" +
                "  $giftId: ID!" +
                "  $collectionDate: Date!" +
                ") {" +
                "  updateRequestWebForm(" +
                "    id: $id" +
                "    status: $status" +
                "    quantity_object: { unit: KG, amount: $amount }" +
                "    selectedGifts: { create: { gift: { connect: $giftId } } }" +
                "    collection_date: $collectionDate" +
                "    address: { connect: $addressId }" +
                "  ) {" +
                "    id" +
                "    status" +
                "    collection_date" +
                "    customer {" +
                "      name" +
                "      phone" +
                "    }" +
                "  }" +
                "}");
        query.setVariable(request);
        return query;
    }
}
