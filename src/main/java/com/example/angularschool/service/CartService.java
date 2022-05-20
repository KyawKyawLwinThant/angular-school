package com.example.angularschool.service;

import com.example.angularschool.ds.Course;
import com.example.angularschool.ds.CourseCart;
import com.example.angularschool.ds.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CourseCart courseCart;

    public int cartSize=0;


    public void addToCart(Course course){
        //if(!courseCart.getCourses().contains(course)) {
            courseCart.addCourse(course);
        updateCartSize();
        // }
    }

    private void updateCartSize() {
        cartSize = courseCart.getCourses().size();
    }

    public List<CourseDto> allCoursesInCart(){
        return courseCart.getCourses();
    }

    public void  clearCart(){
        courseCart.clearCart();
        updateCartSize();
    }

    public void removeCartCourse(Course course){
        courseCart.removeCourse(course);
        updateCartSize();
    }



}
