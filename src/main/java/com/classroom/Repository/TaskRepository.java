package com.classroom.Repository;

import com.classroom.Entiry.Classroom;
import com.classroom.Entiry.Student;
import com.classroom.Entiry.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, String>{

    List<Tasks> findByClassroom(Classroom classroom);
}
