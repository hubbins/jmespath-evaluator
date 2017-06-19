package com.hubbins.jmespath.web.jmespathevaluator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EvaluatorController {

    @RequestMapping("/evaluate")
    public String evaluate(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "evaluate";
    }

}