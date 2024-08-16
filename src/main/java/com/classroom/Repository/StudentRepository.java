package com.classroom.Repository;

import com.classroom.Entiry.Classroom;
import com.classroom.Entiry.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByStudentName(String studentName);

    @Query("SELECT c.classroomId,c.classroomName FROM Classroom c JOIN c.enrolledStudents s WHERE s.studentId = ?1")
    Object findClassroomsByStudentId(String studentId);

    Boolean findByClassroomsContains(Classroom classroom);


}
