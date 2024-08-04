package com.example.java6.Service;

import com.example.java6.Entity.store.Students;

import java.util.List;

public interface StudentsService {
    List<Students> getAllStudents();

    void saveStudents(Students students);

    void deleteStudents();
}
