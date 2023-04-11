package com.example.waa;

import com.example.waa.domains.Address;
import com.example.waa.domains.Course;
import com.example.waa.domains.CourseDetails;
import com.example.waa.domains.Student;
import com.example.waa.repositories.AddressRepo;
import com.example.waa.repositories.CourseDetailsRepo;
import com.example.waa.repositories.CourseRepo;
import com.example.waa.repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class WaaApplication implements CommandLineRunner {
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final CourseDetailsRepo courseDetailsRepo;
    private final AddressRepo addressRepo;

    public static void main(String[] args) {
        SpringApplication.run(WaaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Address address= Address.builder()
//                .city("new city")
//                .state("new State")
//                .zipCode("new zip")
//                .build();
        Address address= new Address();
        address.setCity("new city");
        address.setState("new state");
        address.setZipCode("3424");
        //        Student student= Student.builder()
//                .name("new Student")
//                .gpa(3.5)
//                .build();
        Student student= new Student();
        student.setName("new Student");
        student.setGpa(3.4);
//        Course course= Course.builder()
//                .name("new Course")
//                .id(342)
//                .build();
        Course course= new Course();
        course.setName("new Course");
        course.setId(341);

//        CourseDetails courseDetails1= CourseDetails.builder()
//                .courseDescription("this is an awesome course")
//                .credits(3)
//                .program("MDC")
//                .lastUpdated(2014)
//                .build();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setCourseDescription("a new course detrails");
        courseDetails.setCredits(2);
        courseDetails.setProgram("MFD");
        courseDetails.setLastUpdated(3213);

        address.addStudent(student);
        student.setAddress(address);
       student.addCourse(course);
        course.addStudent(student);
        course.setCourseDetails(courseDetails);
        courseDetails.setCourse(course);


        addressRepo.save(address);
        courseRepo.save(course);
        studentRepo.save(student);

        List<Student> all = studentRepo.findAllStudents();
        for (Student s : all){
            System.out.println(s);
        }


    }
}
