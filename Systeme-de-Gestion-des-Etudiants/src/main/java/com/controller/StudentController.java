package com.controller;

import com.DAO.StudentDAO;
import com.DAO.StudentDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    private final List<Student> studentList = new ArrayList<>();

    @Autowired
    private StudentDAO studentDAO;


    @GetMapping(value = "/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentDAO.getAllStudents(studentList);
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping(value = "/{studentId}")
    public String showStudentDetails(@PathVariable int studentId, Model model) {
        Student student = studentDAO.getStudentById(studentId, studentList);
        model.addAttribute("student", student);
        return "student-details";
    }

    @GetMapping("/add")
    public String addStudentForm(ModelMap modelMap) {
        modelMap.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/add")
    public String addStudentSubmit(@ModelAttribute Student student) {
        studentDAO.addStudent(student, studentList);
        return "redirect:/students/";
    }


    @RequestMapping(value = "/update/{studentId}", method = RequestMethod.POST)
    public String updateStudent(@PathVariable int studentId, @ModelAttribute("student") Student updatedStudent, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "update-student-form";
        }
        studentDAO.updateStudent(studentId, updatedStudent, studentList);
        return "redirect:/students/";
    }

    @RequestMapping(value = "/delete/{studentId}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int studentId) {
        studentDAO.deleteStudent(studentId, studentList);
        return "redirect:/students/";
    }

}
