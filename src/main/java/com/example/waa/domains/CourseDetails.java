package com.example.waa.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String courseDescription;
    private String program;
    private int credits;
    private int lastUpdated;
    @OneToOne
    private Course course;

    @Override
    public String toString() {
        return "CourseDetails{" +
                "id=" + id +
                ", courseDescription='" + courseDescription + '\'' +
                ", program='" + program + '\'' +
                ", credits=" + credits +
                ", lastUpdated=" + lastUpdated +

                '}';
    }
}
