package com.DAO;
import com.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents(List<Student> studentList);
    Student getStudentById(int studentId, List<Student> studentList);
    void addStudent(Student student, List<Student> studentList);
    void updateStudent(int studentId, Student updatedStudent, List<Student> studentList);
    void deleteStudent(int studentId, List<Student> studentList);
}
