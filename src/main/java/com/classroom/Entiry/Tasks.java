package com.classroom.Entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {

    @Id
    private String taskId;
    private String title;
    private String description;
    private String dueDate;
    @ManyToOne
    private Classroom classroom;

}
