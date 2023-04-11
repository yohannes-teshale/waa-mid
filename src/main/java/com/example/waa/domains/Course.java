package com.example.waa.domains;

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
public class Course {
    @Id
    private long id;
    private String name;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students= new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("course")

    private CourseDetails courseDetails;

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +

                ", courseDetails=" + courseDetails +
                '}';
    }
}
