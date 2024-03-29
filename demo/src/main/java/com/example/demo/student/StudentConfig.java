package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student gourane = new Student(
                    "Gourane",
                    "gouraneInpt@gmail.com",
                    LocalDate.of(2003, 02, 13));

            Student anas = new Student(
                    "Anas",
                    "anasInpt@gmail.com",
                    LocalDate.of(1989, 02, 13));

            repository.saveAll(
                    List.of(gourane, anas));

        };
    }
}