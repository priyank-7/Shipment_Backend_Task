package com.classroom.Repository;

import com.classroom.Entiry.Classroom;
import com.classroom.Entiry.Student;
import com.classroom.Entiry.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String> {

    List<Classroom> findClassroomByTeacher(Teacher teacher);

    List<Classroom> findClassroomByEnrolledStudentsContains(Student student);

}
