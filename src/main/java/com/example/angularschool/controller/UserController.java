package com.example.angularschool.controller;

import com.example.angularschool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/user/allcourses")
    public String allCourses(Model model){
        model.addAttribute("courses",courseService.findAll());
        return "user/allcourses";
    }
}
