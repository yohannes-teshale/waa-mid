package com.example.waa.domains;

import com.example.waa.domains.Address;
import com.example.waa.domains.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double gpa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("students")

    private Address address;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "studentAndCourses",
    joinColumns = {@JoinColumn(name = "studentID")},
    inverseJoinColumns = {@JoinColumn(name="courseID")})
    @JsonIgnoreProperties("students")
    private List<Course> courses= new ArrayList<>();

    public void addCourse(Course course){

       this.courses.add(course);
        System.out.println(courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                ", address=" + address +
                ", courses=" + courses +
                '}';
    }
}
