package com.classroom.Entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SubmissionId.class)
public class TaskSubbmission {

    @Id
    private SubmissionId submissionId;
    private Date submissionDate;
    private Boolean isSubmitted;
}
