package com.example.java6.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String name;
    Boolean gender = false;
    Double marks = 0.0;
}
