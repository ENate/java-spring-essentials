package com.minejavarxjpa.reactorjpaexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class CourseWork {

     @Id
     @Column("id")
     private Long id;

     @Column("student_id")
     private Long studentId;

     @Column("course_id")
     private Long courseId;

     @Column("marks")
     private Integer marks;
}
