package com.sunglowsys.resource;

import com.sunglowsys.domain.User;
import com.sunglowsys.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/")
    public String  login() {
        return "login";
    }


    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @GetMapping("/home")
    public String homePage() {

        return "home";
    }
}
