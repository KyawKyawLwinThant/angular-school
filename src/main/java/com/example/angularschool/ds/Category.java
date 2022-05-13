package com.example.angularschool.ds;


import com.example.angularschool.validator.NotAdmin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends IdClass{

    @NotAdmin
    @NotEmpty(message = "{course.name.valid.empty}")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Course> courseList=
            new ArrayList<>();

    public Course addCourse(Course course){
        course.setCategory(this);
        courseList.add(course);
        return course;
    }

    public void remove(){
        courseList.remove(this);
       // this.getCourseList().remove(this);
    }
}
