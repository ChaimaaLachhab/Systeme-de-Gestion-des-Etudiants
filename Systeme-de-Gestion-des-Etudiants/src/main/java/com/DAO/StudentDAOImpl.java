package com.DAO;

import com.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> getAllStudents(List<Student> studentList) {
        return studentList;
    }

    @Override
    public Student getStudentById(int studentId, List<Student> studentList) {
        for (Student student : studentList) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent(Student student, List<Student> studentList) {
        studentList.add(student);
    }

    @Override
    public void updateStudent(int studentId, Student updatedStudent, List<Student> studentList) {
        for (Student student : studentList) {
            if (student.getId() == studentId) {
                student.setName(updatedStudent.getName());
                student.setStudentNumber(updatedStudent.getStudentNumber());
                student.setEmail(updatedStudent.getEmail());
                student.setPhoneNumber(updatedStudent.getPhoneNumber());
                student.setAddress(updatedStudent.getAddress());
                break;
            }
        }
    }

    @Override
    public void deleteStudent(int studentId, List<Student> studentList) {
        studentList.removeIf(student -> student.getId() == studentId);
    }
}
