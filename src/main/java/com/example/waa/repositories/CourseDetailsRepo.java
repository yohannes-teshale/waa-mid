package com.example.waa.repositories;

import com.example.waa.domains.CourseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseDetailsRepo extends JpaRepository<CourseDetails,Long> {

}
