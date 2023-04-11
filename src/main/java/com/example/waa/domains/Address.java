package com.example.waa.domains;

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
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String city;
    private String state;
    private String zipCode;
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private List<Student> students= new ArrayList<>();


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +

                '}';
    }

    public void addStudent(Student student){
        this.students.add(student);

    }
}
