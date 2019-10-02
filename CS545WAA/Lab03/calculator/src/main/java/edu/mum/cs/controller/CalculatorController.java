package edu.mum.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.domain.Calculator;
import edu.mum.cs.validator.Validator;

@Controller
public class CalculatorController {

    @Autowired
    Validator calculatorValidator;

    @RequestMapping(value = {"/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/Calculator"})
    public String inputCalculator() {
        return "calculator";
    }

    @RequestMapping(value = {"/CalculatorPost"}, method = RequestMethod.POST)
    public String CalculatorPost(Calculator calculator, Model model) {

        // Check for valid inputs....
        List<String> errors = calculatorValidator.validate(calculator);
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "result";
        }
        calculator.calSum();
        calculator.calProduct();
        // Another "view" of how to use PrintWriter
        return "result";
    }
}