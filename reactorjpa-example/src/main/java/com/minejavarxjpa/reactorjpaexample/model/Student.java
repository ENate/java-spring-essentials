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
@Table("students")
public class Student {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("registered_on")
    private Long registeredOn;

    @Column("status")
    private Long status;

}
