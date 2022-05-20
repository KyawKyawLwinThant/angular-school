package com.example.angularschool.dao;

import com.example.angularschool.ds.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<Users,Integer> {

    public Optional<Users> findByEmail(String email);
}
