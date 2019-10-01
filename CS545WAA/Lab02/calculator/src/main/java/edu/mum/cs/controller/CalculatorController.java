package edu.mum.cs.controller;

import javax.servlet.http.HttpServletRequest;

import edu.mum.cs.domain.Calculator;
import mum.edu.framework.annotation.Controller;
import mum.edu.framework.annotation.RequestMapping;

@Controller
public class CalculatorController {
    @RequestMapping(value={"/Calculator"})
	public String inputCalculator() {
		return "/WEB-INF/calculator.jsp";
    }
    
    @RequestMapping(value={"/CalculatorPost"})
	public String CalculatorPost(Calculator calculator, HttpServletRequest request) {
        String add1 = request.getParameter("add1").trim();
        String add2 = request.getParameter("add2").trim();
        String mult1 = request.getParameter("mult1").trim();
        String mult2 = request.getParameter("mult2").trim();

        String sum = "";
        String product = "";

        // Check for valid inputs....
        try {
            Integer a1 = Integer.parseInt(add1);
            Integer a2 = Integer.parseInt(add2);
            sum = "" + (a1 + a2);
        } catch (NumberFormatException e) {
            if (add1.isEmpty()) add1 = "''";
            if (add2.isEmpty()) add2 = "''";
            sum = "''";
        }

        /*
         * Integer.parseInt(str) throws NumberFormatException
         * if the string cannot be converted to an integer.
         */

        try {
            Integer m1 = Integer.parseInt(mult1);
            Integer m2 = Integer.parseInt(mult2);
            product = "" + (m1 * m2);
        } catch (NumberFormatException e) {
            if (mult1.isEmpty()) mult1 = "''";
            if (mult2.isEmpty()) mult2 = "''";
            product = "''";
        }


        // Another "view" of how to use PrintWriter
        request.setAttribute("add1", add1);
        request.setAttribute("add2", add2);
        request.setAttribute("mult1", mult1);
        request.setAttribute("mult2", mult2);
        request.setAttribute("sum", sum);
        request.setAttribute("product", product);
		return "/WEB-INF/result.jsp";
	}
}