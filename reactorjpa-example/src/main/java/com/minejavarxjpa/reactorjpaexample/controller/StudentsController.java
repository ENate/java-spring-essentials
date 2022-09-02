package com.minejavarxjpa.reactorjpaexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.minejavarxjpa.reactorjpaexample.repository.StudentsRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
public class StudentsController {
    private StudentsRepository studentsRepository;

    @GetMapping("/students/{studentID}")
    Mono<Object> getStudent(@PathVariable Long studentId) {
        return studentsRepository.findById(studentId).map(student -> {
            return new ResponseEntity<>(student, HttpStatus.OK);
        });
    }
}
