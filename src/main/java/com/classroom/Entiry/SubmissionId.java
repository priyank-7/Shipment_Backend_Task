package com.classroom.Entiry;

import jakarta.persistence.IdClass;

import java.io.Serializable;

@IdClass(TaskSubbmission.class)
public class SubmissionId implements Serializable{

    private Tasks task;
    private Classroom classroom;
    private Student student;
}
