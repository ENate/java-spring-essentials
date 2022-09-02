package com.minejavarxjpa.reactorjpaexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("courses")
public class Courses {

    @Id
    @Column("id")
    private Long id;

    @Column("course_name")
    private String coursename;
}
