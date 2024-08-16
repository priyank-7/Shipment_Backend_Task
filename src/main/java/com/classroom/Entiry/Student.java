package com.classroom.Entiry;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    private String studentId;
    private String studentName;
    private String studentEmail;
    @OneToMany
    private List<Classroom> classrooms;
}
