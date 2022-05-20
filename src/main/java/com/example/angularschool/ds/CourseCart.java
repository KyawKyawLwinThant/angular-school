package com.example.angularschool.ds;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Component
public class CourseCart {



    private List<CourseDto> courses=
            new ArrayList<>();

    public void addCourse(Course course){
        courses.add(courseToDto(course));
    }

    private CourseDto courseToDto(Course course) {
        return new CourseDto(course.getId(),
                course.getTitle(),
                course.getDuration(),
                course.getPrice(),
                course.getImageUrl(),
                course.getDescription());
    }





    public void removeCourse(Course course){
        courses.remove(courseToDto(course));
    }

    public void clearCart(){
        courses.clear();
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public int getCartSize(){
        return courses.size();
    }
}
