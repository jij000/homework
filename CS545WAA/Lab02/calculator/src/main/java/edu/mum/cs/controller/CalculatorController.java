package edu.mum.cs.controller;

import javax.servlet.http.HttpServletRequest;

import edu.mum.cs.domain.Calculator;
import edu.mum.cs.validator.Validator;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.Controller;
import mum.edu.framework.annotation.RequestMapping;

import java.util.List;

@Controller
public class CalculatorController {
    @AutoWired
    Validator calculatorValidator;

    @RequestMapping(value = {"/Calculator"})
    public String inputCalculator() {
        return "/WEB-INF/calculator.jsp";
    }

    @RequestMapping(value = {"/CalculatorPost"})
    public String CalculatorPost(Calculator calculator, HttpServletRequest request) {

        request.setAttribute("calculator", calculator);
        // Check for valid inputs....
        List<String> errors = calculatorValidator.validate(calculator);
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            return "/WEB-INF/result.jsp";
        }
        calculator.calSum();
        calculator.calProduct();
        // Another "view" of how to use PrintWriter
        return "/WEB-INF/result.jsp";
    }
}