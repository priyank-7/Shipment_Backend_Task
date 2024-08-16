package com.classroom.Service;

import com.classroom.Entiry.Classroom;
import com.classroom.Entiry.Teacher;
import com.classroom.Repository.ClassroomRepository;
import com.classroom.Repository.TeacherRepository;
import com.classroom.helpers.ClassEditDto;
import com.classroom.helpers.ClassresponseDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ClassroomRepository classroomRepository;

    public TeacherService(TeacherRepository teacherRepository, ClassroomRepository classroomRepository){
        this.teacherRepository = teacherRepository;
        this.classroomRepository = classroomRepository;
    }

    public ClassresponseDto createClassroom(String teacherId, ClassEditDto classroom) {

        Teacher teacher = this.teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        Classroom savedClass = this.classroomRepository.save(Classroom.builder()
                .classroomId(UUID.randomUUID().toString())
                .classroomName(classroom.getClassroomName())
                .teacher(teacher)
                .build());
        return ClassresponseDto.builder()
                .classroomId(savedClass.getClassroomId())
                .classroomName(savedClass.getClassroomName())
                .build();
    }


    public Object viewClassrooms(String teacherId) {
        return this.classroomRepository.findClassroomByTeacher(this.teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found")));
    }
}
