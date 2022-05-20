package com.example.angularschool.dao;

import com.example.angularschool.ds.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolesDao extends JpaRepository<Roles,Integer> {
}
