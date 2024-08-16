package com.classroom.Repository;

import com.classroom.Entiry.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String> {

    void deleteClassroomByClassroomName(Classroom classroomName);

    Optional<Classroom> findClassroomByClassroomName(String classroomName);

}
