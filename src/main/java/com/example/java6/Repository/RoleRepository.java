package com.example.java6.Repository;

import com.example.java6.Entity.store.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Object> {
}
