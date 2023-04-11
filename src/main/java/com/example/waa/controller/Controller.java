package com.example.waa.controller;

import com.example.waa.domains.Student;
import com.example.waa.repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Controller {
    private final StudentRepo studentRepo;
    @GetMapping
    List<Student> getAllOfThem(){
        List<Student> allStudents = studentRepo.findAllStudents();
       return allStudents;

    }

}
