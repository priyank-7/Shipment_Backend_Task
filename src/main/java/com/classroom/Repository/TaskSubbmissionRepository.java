package com.classroom.Repository;

import com.classroom.Entiry.SubmissionId;
import com.classroom.Entiry.TaskSubbmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSubbmissionRepository extends JpaRepository<TaskSubbmission, SubmissionId> {

}
