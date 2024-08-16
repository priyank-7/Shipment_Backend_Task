package com.classroom.Entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tasks {

    @Id
    private String taskId;
    private String title;
    private String description;
    private Date dueDate;
    @ManyToOne
    private Classroom classroom;

}
