package com.hubbins.jmespath.web.jmespathevaluator;

import java.io.Serializable;

public class EvaluatorRequest implements Serializable {
    private String expression;
    private String json;

    public EvaluatorRequest() {}

    public EvaluatorRequest(String expression, String json) {
        this.expression = expression;
        this.json = json;
    }

    public String getExpression() { return this.expression; }
    public void setExpression(String expression) { this.expression = expression; }
    public String getJson() { return this.json; }
    public void setJson(String json) { this.json = json; }
}
