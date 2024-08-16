package com.classroom;

import com.classroom.Entiry.Classroom;
import com.classroom.Entiry.Student;
import com.classroom.Entiry.Teacher;
import com.classroom.Repository.ClassroomRepository;
import com.classroom.Repository.StudentRepository;
import com.classroom.Repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ClassroomApiApplicationTests {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void SaveTeacher() {
        Teacher teacher = Teacher.builder().teacherName("John Doe")
                .teacherId(UUID.randomUUID().toString())
                .build();
        teacherRepository.save(teacher);
    }

    @Test
    void AddStudent(){
        Student student = Student.builder()
                .studentId(UUID.randomUUID().toString())
                .studentName("Jane Doe")
                .studentEmail("john@gmail.com")
                .build();
        this.studentRepository.save(student);

    }

    @Test
    void SaveClassroom() {

        Teacher teacher = Teacher.builder().teacherName("John Doe")
                .teacherId(UUID.randomUUID().toString())
                .build();
        teacherRepository.save(teacher);

        Classroom classroom = Classroom.builder().classroomName("Maths")
                .classroomId(UUID.randomUUID().toString())
                .teacher(teacher)
                .build();
        this.classroomRepository.save(classroom);
    }
}
