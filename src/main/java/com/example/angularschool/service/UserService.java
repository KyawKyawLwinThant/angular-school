package com.example.angularschool.service;


import com.example.angularschool.dao.CourseDao;
import com.example.angularschool.dao.RolesDao;
import com.example.angularschool.dao.UserCourseDao;
import com.example.angularschool.dao.UsersDao;
import com.example.angularschool.ds.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsersDao usersDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserCourseDao userCourseDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesDao rolesDao;

    //for understanding , we need this code to refactor.
    @Transactional
    public void checkOut(Users users, List<CourseDto> courses){
        UserCourse userCourse=new UserCourse();
        Roles roles=new Roles();
        roles.setName("ROLE_USER");
        users.addRole(rolesDao.save(roles));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userCourse.setUser(usersDao.save(users));
       List<Course> courseList=courseDtoToEntity(courses);
       for(Course course:courseList){
           userCourse.addCourse(course);
       }
       userCourseDao.save(userCourse);

    }

    private List<Course> courseDtoToEntity(List<CourseDto> courseDtos){
        List<Course> courses=new ArrayList<>();
        for(CourseDto courseDto:courseDtos){
            courses.add(courseDao.getById(courseDto.getId()));
        }
        return courses;
    }

    @Transactional
    public List<Course> getCoursesByUserId(String  email) {
        return userCourseDao.findUserCourseByUserId(email)
                .getCourseList();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> users=usersDao.findByEmail(email);
        if(!users.isPresent()){
            throw new UsernameNotFoundException(email + " Not Found!");
        }
        return users.get();
    }
}
