package com.example.angularschool.dao;

import com.example.angularschool.ds.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseDao extends JpaRepository<UserCourse,Integer> {
    @Query("select u from UserCourse u where u.user.email =:email")
    UserCourse findUserCourseByUserId(@Param("email")String email);
}
