package models;

public class Query {

    private String query;
    private Object variable;

    public Query() {
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setVariable(Object variable) {
        this.variable = variable;
    }

    public String getQuery() {
        return query;
    }

    public Object getVariable() {
        return variable;
    }
}


