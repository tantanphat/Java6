package com.example.java6.Repository;

import com.example.java6.Entity.store.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Object> {
}
