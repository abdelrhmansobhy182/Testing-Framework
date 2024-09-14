package backend.services;

import backend.GraphQLQuery;
import backend.models.User;

public class LoginService {

    public static GraphQLQuery LoginMutation(User user) {

        GraphQLQuery graphQLQuery = new GraphQLQuery();
        graphQLQuery.setQuery( "mutation login($type: AuthType!, $role: Roles!, $phone: String!, $password: String!) {" +
                "  login(" +
                "    type: $type," +
                "    role: $role," +
                "    phone: $phone," +
                "    password: $password" +
                "  ) {" +
                "    id" +
                "    phone" +
                "    role" +
                "    interfaces" +
                "    type" +
                "    jwtToken" +
                "  }" +
                "}");
        graphQLQuery.setVariable(user);
        return graphQLQuery;
    }
}
