package edu.mum.cs.controller;

import edu.mum.cs.data.TestDataImpl;
import edu.mum.cs.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class AuthenticationController {

    @Autowired
    TestDataImpl data;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginSuccessful(User user, Model model) {

        String expectedPassword = data.findPassword(user.getName());

        if (expectedPassword == null || !expectedPassword.equals(user.getPassword())) {
            String error = "Username or Password is invalid";
            model.addAttribute("error", error);
            return "login";
        } else {
            return "LoginSuccessful";
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(User user, Model model, SessionStatus status) {
        status.setComplete();
        return "redirect:login";
    }
}