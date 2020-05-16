package edu.mum.swa.servicea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping(value = { "/salary" }, produces = "application/json")
    public String salary() {
        return "99";
    }
}