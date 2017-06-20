package com.hubbins.jmespath.web.jmespathevaluator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

import io.burt.jmespath.JmesPath;
import io.burt.jmespath.Expression;
import io.burt.jmespath.jackson.JacksonRuntime;

@Controller
@RequestMapping("/evaluator")
public class EvaluatorController {

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody EvaluatorResponse evaluate(@RequestBody EvaluatorRequest request) {
        String response = "", errorMessage = "";

        JmesPath<JsonNode> jmespath = new JacksonRuntime();
        try {
            Expression<JsonNode> expression = jmespath.compile(request.getExpression());
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            JsonNode jsonObj = mapper.readTree(request.getJson());
            JsonNode result = expression.search(jsonObj);
            response = mapper.writeValueAsString(result);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }

        return new EvaluatorResponse(response, errorMessage);
    }

}
