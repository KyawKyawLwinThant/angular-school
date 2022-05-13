package com.example.angularschool.dao;

import com.example.angularschool.ds.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {
}
