package com.spring.hello_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hello_spring_boot.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
