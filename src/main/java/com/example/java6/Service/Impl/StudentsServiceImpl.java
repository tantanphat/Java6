package com.example.java6.Service.Impl;

import com.example.java6.Entity.store.Students;
import com.example.java6.Repository.StudentsRepository;
import com.example.java6.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public void saveStudents(Students students) {
        studentsRepository.save(students);
    }

    @Override
    public void deleteStudents() {
        studentsRepository.deleteAll();
    }
}
