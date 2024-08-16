package com.classroom.Service;

import com.classroom.Entiry.Classroom;
import com.classroom.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Object viewClassrooms(String studentId) {
        return this.studentRepository.findClassroomsByStudentId(studentId);
    }

//    public Object viewTasks(String studentId, String classroomId) {
//        return this.studentRepository.findTasksByStudentIdAndClassroomId(studentId, classroomId);
//    }
}
