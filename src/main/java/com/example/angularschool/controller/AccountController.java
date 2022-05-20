package com.example.angularschool.controller;


import com.example.angularschool.dao.RolesDao;
import com.example.angularschool.dao.UsersDao;
import com.example.angularschool.ds.Roles;
import com.example.angularschool.ds.Users;
import com.example.angularschool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
    private RolesDao rolesDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/make/admin")
    @ResponseBody
    @Transactional
    public String makeAdmin(){

        Users users=new Users();
        users.setPassword(passwordEncoder.encode("12345"));
        users.setAddress("Dream Land");
        users.setEmail("john@gmail.com");
        users.setFirstName("John");
        users.setLastName("Doe");
        users.setPhoneNumber("55-55-555");
        Roles roles=new Roles();
        roles.setName("ROLE_ADMIN");
        users.addRole(rolesDao.save(roles));
        usersDao.save(users);

        return "successful admin!";
    }


}
