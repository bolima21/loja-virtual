package com.dev.backend.repository;

import com.dev.backend.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findByName(String name);
}
