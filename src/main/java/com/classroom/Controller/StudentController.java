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

}
