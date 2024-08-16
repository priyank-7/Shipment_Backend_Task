package com.classroom.Controller;


import com.classroom.Service.ClassroomService;
import com.classroom.dtos.AddRemoveStudent;
import com.classroom.helpers.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService){
        this.classroomService = classroomService;
    }


    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("/{classroomId}/students")
    public ResponseEntity<?> addStudentToClassroom(String classroomId, @RequestBody AddRemoveStudent student){
        return ResponseEntity.ok(this.classroomService.addStudentToClassroom(classroomId, student.getStudentName()));
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @DeleteMapping("/{classroomId}/students")
    public ResponseEntity<?> removeStudentFromClassroom(String classroomId, @RequestBody AddRemoveStudent student){
        if(this.classroomService.removeStudentFromClassroom(classroomId, student.getStudentName())){
            return ResponseEntity.ok("Student updated successfully");
        }
        return ResponseEntity.ok("Student not found");
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PutMapping("/{classroomId}")
    public ResponseEntity<?> editClassroom(@PathVariable String classroomId, @RequestBody AddRemoveStudent student){
        if(this.classroomService.deleteClassroom(classroomId)){
            return ResponseEntity.ok("Classroom removed successfully");
        }
        return ResponseEntity.ok("Classroom not found");
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("/{classroomId}/tasks")
    public ResponseEntity<?> assignTaskToClassroom(String classroomId, @RequestBody TaskDto task){
        return ResponseEntity.ok(this.classroomService.assignTaskToClassroom(classroomId, task));
    }

//    Task Submission Status:
//    Teachers can view which students have or have not submitted tasks.
//    API Endpoint: GET /classrooms/{classroomId}/tasks/{taskId}/submissions
//    Response: [{ "studentId": "string", "studentName": "string", "status": "submitted/pending" }]

//    @PreAuthorize("hasRole('ROLE_TEACHER')")
//    @GetMapping("/{classroomId}/tasks/{taskId}/submissions")
//    public ResponseEntity<?> getTaskSubmissionStatus(String classroomId, String taskId){
//        return ResponseEntity.ok(this.classroomService.getTaskSubmissionStatus(classroomId, taskId));
//    }



}
