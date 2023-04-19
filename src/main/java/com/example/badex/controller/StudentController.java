package com.example.badex;

import com.example.badex.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {


    final StudentService studentService;

    @Autowired
    public HelloController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/mvc")
    @ResponseBody
    public String mvc() {
        return "Hello in a Spring MVC";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "hello";
    }

    @GetMapping("/student")
    public String getStudent(Model model) {
        final List<Student> all = studentService.getAll();
        model.addAttribute("student", all);
        return "student";
    }

    @GetMapping("/form")
    public String showStudentForm() {
        return "jadder";
    }

    @GetMapping("/st")
    public String home(Model model) {
        model.addAttribute("students", studentService.studentRepo.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam String type) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setType(type);
        studentService.save(student);
        return "redirect:/st";
    }

}
