package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;

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

    public void deleteStudent(Long studentId) {
        Boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("There is no Student with the id :" + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "There is no Student with the id :" + studentId));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
            System.out.println("name updated successfully");
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            Optional<Student> X = studentRepository.findStudentByEmail(student.getEmail());
            if (X.isPresent()) {
                throw new IllegalStateException("email alredy used");
            }

            student.setEmail(email);
            System.out.println("email updated successfully");
        }

        studentRepository.save(student);
        System.out.println("changes saved successfully");

    }
}