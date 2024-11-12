package backend.services;

import models.Query;
import models.requests.BusinessRequest;
import models.requests.CustomerRequest;
import models.requests.Request;

public class RequestsService {

    public static Query updateRequestWebForm(CustomerRequest request) {

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
    public static Query createBusinessRequest(BusinessRequest request){
        Query query = new Query();
        query.setQuery("mutation createBusinessRequest(" +
                "  $dayConst: String!," +
                "  $addressId: ID!," +
                "  $amount: Float!," +
                "  $containerId: ID!," +
                "  $containerQuantity: Int!," +
                "  $date: DateTime!," +
                "  $time: String!" +
                ") {" +
                "  createBuisnessRequest(" +
                "    day_const: $dayConst" +
                "    address_id: $addressId" +
                "    quantity: {" +
                "      unit: KG" +
                "      amount: $amount" +
                "    }" +
                "    containers: [" +
                "      {" +
                "        container_id: $containerId" +
                "        quantity: $containerQuantity" +
                "      }" +
                "    ]" +
                "    date_time: {" +
                "      date: $date" +
                "      time: $time" +
                "    }" +
                "  ) {" +
                "    id" +
                "    status" +
                "    collection_date" +
                "    collection_time" +
                "  }" +
                "}");
        query.setVariable(request);
        return query;
    }
}
