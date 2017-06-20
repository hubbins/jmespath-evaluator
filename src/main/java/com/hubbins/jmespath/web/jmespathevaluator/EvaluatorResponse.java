package com.hubbins.jmespath.web.jmespathevaluator;

import java.io.Serializable;

public class EvaluatorResponse implements Serializable {
    private String result;
    private String errorMessage;

    public EvaluatorResponse() {}

    public EvaluatorResponse(String result, String errorMessage) {
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public String getResult() { return this.result; }
    public void setResult(String result) { this.result = result; }
    public String getErrorMessage() { return this.errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
