package com.example.waa.repositories;

import com.example.waa.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
    @Query("select s from Student  s join fetch s.address a join fetch s.courses c")
    List<Student> findAllStudents();
}
