package edu.mum.cs.controller;

import edu.mum.cs.data.TestDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdviceController {

    @Autowired
    TestDataImpl data;

    @RequestMapping(value = {"/advice"}, method = RequestMethod.GET)
    public String inputCalculator(Model model) {
        Map< String, String > roastMap = new HashMap<String, String>();

        roastMap.put("Light", "light");
        roastMap.put("Medium", "medium");
        roastMap.put("Dark", "dark");

        model.addAttribute("roasts", roastMap);
        return "advice";
    }

    @RequestMapping(value = {"/advice"}, method = RequestMethod.POST)
    public String CalculatorPost(@RequestParam String roast, Model model) {

        List<String> advice = data.getAdvice(roast);

        model.addAttribute("roastList", advice);

        return "display";
    }
}