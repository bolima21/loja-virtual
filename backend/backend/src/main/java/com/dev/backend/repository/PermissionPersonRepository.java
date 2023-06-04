package com.dev.backend.repository;

import com.dev.backend.entity.PermissionPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionPersonRepository extends JpaRepository<PermissionPerson, Long> {
}
