package com.spring.hello_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hello_spring_boot.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
