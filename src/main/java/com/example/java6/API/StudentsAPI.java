package com.example.java6.API;

import com.example.java6.Entity.store.Students;
import com.example.java6.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentsAPI {
    @Autowired
    private StudentsService studentsService;
    @GetMapping("")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.getAllStudents());
    }

        @PostMapping("")
        public ResponseEntity<?> addStudent(@RequestBody Students student) {
            try {
                studentsService.saveStudents(student);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving student.");
            }
        }

        @DeleteMapping("")
        public ResponseEntity<?> deleteStudent() {
        studentsService.deleteStudents();
        return ResponseEntity.status(HttpStatus.OK).body("OK");
        }
}
