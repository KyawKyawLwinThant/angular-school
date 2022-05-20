package com.example.angularschool.service;


import com.example.angularschool.dao.CategoryDao;
import com.example.angularschool.dao.CourseDao;
import com.example.angularschool.ds.Category;
import com.example.angularschool.ds.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    private final CourseDao courseDao;
    private final CategoryDao categoryDao;

    public CourseService(CourseDao courseDao, CategoryDao category) {
        this.courseDao = courseDao;
        this.categoryDao = category;
    }

    @Transactional
    public Course findCourse(int id) {
        return courseDao.getById(id);
    }

    @Transactional
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Transactional
    public Course saveCourse(int catId, Course course) {
        Category category = categoryDao.getById(catId);
        return courseDao.save(category.addCourse(course));
    }

    @Transactional
    public void removeCourse(int courseId) {
        Course course = findCourse(courseId);
        course.getCategory().remove();
        courseDao.delete(course);
    }

    @Transactional
    public Course updateCourse(int courseId, Course newCourse, int catId) {
        Course oldCourse = findCourse(courseId);
        Category category = categoryDao.getById(catId);

        oldCourse.setDescription(newCourse.getDescription());
        oldCourse.setDuration(newCourse.getDuration());
        oldCourse.setPrice(newCourse.getPrice());
        oldCourse.setTitle(newCourse.getTitle());
        oldCourse.setImageUrl(newCourse.getImageUrl());

        category.addCourse(oldCourse);
        return oldCourse;
    }





}
