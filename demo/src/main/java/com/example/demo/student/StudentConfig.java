package com.example.demo.student;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student gourane = new Student(1L,
                    "A",
                    21,
                    "gouraneInpt@gmail.com",
                    LocalDate.of(2003, 02, 13));

            Student anas = new Student(2L,
                    "A",
                    21,
                    "anasInpt@gmail.com",
                    LocalDate.of(2003, 02, 13));

            repository.save(gourane);
            repository.save(anas);

        };
    }
}