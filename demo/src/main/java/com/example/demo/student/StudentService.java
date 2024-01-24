package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void createStudent(Student student) {
        System.out.println("recived a new " + student);

        Optional<Student> X = studentRepository.findStudentByEmail(student.getEmail());

        if (X.isPresent()) {
            throw new IllegalStateException("email alredy used");
        } else {
            studentRepository.save(student);
            System.out.println("Student saved successfully");
        }
    }
}
