package com.classroom.Service;

import com.classroom.Entiry.Classroom;
import com.classroom.Entiry.Student;
import com.classroom.Entiry.Tasks;
import com.classroom.Repository.ClassroomRepository;
import com.classroom.Repository.StudentRepository;
import com.classroom.Repository.TaskRepository;
import com.classroom.helpers.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassroomService {


    private final ClassroomRepository classroomRepository;
    private final StudentRepository studentRepository;

    private final TaskRepository taskRepository;

public ClassroomService(ClassroomRepository classroomRepository, StudentRepository studentRepository, TaskRepository taskRepository){
        this.classroomRepository = classroomRepository;
    this.studentRepository = studentRepository;
    this.taskRepository = taskRepository;
}



    // edit class room
    public boolean editClassroom(String classroomId, String classroomName){
    Classroom temp = this.classroomRepository.findById(classroomId)
            .orElseThrow(() -> new RuntimeException("Classroom not found"));
    temp.setClassroomName(classroomName);
        classroomRepository.save(temp);
        return true;
    }

    // delete class room
    public boolean deleteClassroom(String classroomId){
        this.classroomRepository.delete(this.classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found")));
        return true;
    }

    public Boolean addStudentToClassroom(String classroomId, String studentId) {
        Classroom temp = this.classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
        Student student = this.studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        temp.getEnrolledStudents().add(student);
        this.classroomRepository.save(temp);
        return true;
    }

    public Boolean removeStudentFromClassroom(String classroomId, String studentId) {
        Classroom temp = this.classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
        Student student = this.studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        temp.getEnrolledStudents().remove(student);
        this.classroomRepository.save(temp);
        return true;
    }

    // assign task to classroom
    public Boolean assignTaskToClassroom(String classroomId, TaskDto taskDto) {
        Classroom temp = this.classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
        // crate task andd add it to task and then add it to classroom
        Tasks tasks = Tasks.builder()
                .taskId(UUID.randomUUID().toString())
                .title(taskDto.getTaskName())
                .description(taskDto.getTaskDescription())
                .dueDate(taskDto.getDueDate())
                .build();
        temp.getTasks().add(this.taskRepository.save(tasks));
        this.classroomRepository.save(temp);
        return true;
    }

//    public List<> getTaskSubmissionStatus(String classroomId, String taskId) {
//    }
}
