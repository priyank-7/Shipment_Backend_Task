package com.classroom.Service;

import com.classroom.Entiry.Student;
import com.classroom.Repository.ClassroomRepository;
import com.classroom.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;


    public StudentService(StudentRepository studentRepository, ClassroomRepository classroomRepository){
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }

    public Object viewClassrooms(String studentId) {
        return this.classroomRepository.findClassroomByEnrolledStudentsContains(
                this.studentRepository.findById(studentId)
                        .orElseThrow(() -> new RuntimeException("Student not found")));
    }

    public boolean addStudent(Student student) {
        this.studentRepository.save(student);
        return true;
    }
}
