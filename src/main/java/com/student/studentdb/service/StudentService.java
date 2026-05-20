package com.student.studentdb.service;

import com.student.studentdb.model.Student;
import com.student.studentdb.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // CREATE
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ BY ID
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = repository.findById(id).orElseThrow();

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        student.setPhone(updatedStudent.getPhone());
        student.setAddress(updatedStudent.getAddress());

        return repository.save(student);
    }

    // DELETE
    public void deleteStudent(Long id) {
        repository.deleteById(id);

    }
    public List<Student> searchByName(String name) {
        return repository.findByFirstNameContainingIgnoreCase(name);
    }
}