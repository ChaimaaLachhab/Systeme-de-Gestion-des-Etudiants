package com.controller;

import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/{id}")
    public String showStudentDetails(@PathVariable Long id, Model model) {
        studentService.getStudentById(id).ifPresent(student -> model.addAttribute("student", student));
        return "student-details";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student-form";
    }

    @PostMapping("/add")
    public String addStudentSubmit(@ModelAttribute Student student) {
        studentService.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        studentService.getStudentById(id).ifPresent(student -> model.addAttribute("student", student));
        return "update-student-form";
    }

    @PostMapping("/edit/{id}")
    public String editStudentSubmit(@PathVariable Long id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
