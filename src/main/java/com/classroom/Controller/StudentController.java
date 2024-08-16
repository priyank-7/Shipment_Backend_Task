package com.classroom.Controller;

import com.classroom.Entiry.Student;
import com.classroom.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }



    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        return ResponseEntity.ok(this.studentService.addStudent(student));
    }


    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping("/{studentId}/classrooms")
    public ResponseEntity<?> viewClassrooms(@PathVariable String studentId){
        return ResponseEntity.ok(this.studentService.viewClassrooms(studentId));
    }

//    View Tasks:
//    Students can view tasks assigned to their classrooms.
//    API Endpoint: GET /students/{studentId}/classrooms/{classroomId}/tasks
//    Response: [{ "taskId": "string", "title": "string", "description": "string", "dueDate": "YYYY-MM-DD" }]

//    @PreAuthorize("hasRole('ROLE_STUDENT')")
//    @GetMapping("/{studentId}/classrooms/{classroomId}/tasks")
//    public ResponseEntity<?> viewTasks(String studentId, String classroomId){
//        return ResponseEntity.ok(this.studentService.viewTasks(studentId, classroomId));
//    }


}
