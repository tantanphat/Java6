package com.example.java6.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    private String name;
    private String age;
    private String grade;
    private Contact contact;
    private List<Subjects> subjects;

}
