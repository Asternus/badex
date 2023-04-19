package com.example.badex;

import com.example.badex.entity.Student;
import com.example.badex.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public void addUser() {
        final Student student = new Student();
        student.setName("Jon");
        student.setType("Bio");
        student.setEmail("Bio@gmail.com");

        studentRepo.saveAndFlush(student);
    }

    public void save(Student student) {
        studentRepo.saveAndFlush(student);
    }

    public List<Student> getAll() {
        addUser();
        return studentRepo.findAll();
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

}
