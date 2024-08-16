package com.classroom.Controller;

import com.classroom.Service.TeacherService;
import com.classroom.helpers.ClassEditDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("{teacherId}/classrooms")
    public ResponseEntity<?> createClassroom(@PathVariable  String teacherId, @RequestBody ClassEditDto classroom){
        return ResponseEntity.ok(this.teacherService.createClassroom(teacherId, classroom));
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @GetMapping("{teacherId}/classrooms")
    public ResponseEntity<?> viewClassrooms(@PathVariable String teacherId){
        return ResponseEntity.ok(this.teacherService.viewClassrooms(teacherId));
    }
}
