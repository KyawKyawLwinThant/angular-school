package com.example.angularschool.controller;

import com.example.angularschool.ds.Users;
import com.example.angularschool.service.CartService;
import com.example.angularschool.service.CourseService;
import com.example.angularschool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping("/user/allcourses")
    public String allCourses(Model model, Authentication authentication){
        if(authentication !=null){
            System.out.println("Authentication User Name:"+ authentication.getName());
            model.addAttribute("courses",userService.getCoursesByUserId(authentication.getName()));
            return "user/allcourses";
        }
        else{
            model.addAttribute("courses",courseService.findAll());
            model.addAttribute("cartSize",cartService.cartSize);
            return "user/allcourses";
        }
    }

    @GetMapping("/user/course-details")
    public String detailsCourse(@RequestParam("courseId") int courseId, Model model){
        model.addAttribute("course",courseService.findCourse(courseId));
        model.addAttribute("cartSize",cartService.cartSize);
        return "user/course-details";
    }
    @GetMapping("/user/add/cart")
    public String addToCart(@RequestParam("courseId")int courseId, Model model,
                            RedirectAttributes attributes){
        cartService.addToCart(courseService.findCourse(courseId));
        return "redirect:/user/course-details?courseId="+courseId;
    }
    @GetMapping("/user/cart/view")
    public String cartView(Model model){
        model.addAttribute("courses",cartService.allCoursesInCart());
        return "user/cart-view";
    }
    @GetMapping("/user/cart/clear")
    public String clearCart(){
        cartService.clearCart();
        return "redirect:/user/cart/view";
    }
    @GetMapping("/user/cart/remove")
    public String  removeCourseFromCart(@RequestParam("courseId")int courseId,Model model){
        cartService.removeCartCourse(courseService.findCourse(courseId));
        model.addAttribute("cartSize",cartService.cartSize);
        return "redirect:/user/cart/view";
    }
    @GetMapping("/user/cart/checkout")
    public String checkout(Model model){
        model.addAttribute("users",new Users());
        return "user/user-form";
    }
    @PostMapping("/user/cart/checkout")
    public String processUserCheckout(Users users, BindingResult result){
        if(result.hasErrors()){
            return "user/user-form";
        }
        else{
            userService.checkOut(users,cartService.allCoursesInCart());
        }
        return "redirect:/login";
    }

}
