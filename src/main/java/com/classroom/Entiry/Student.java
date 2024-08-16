package com.classroom.Entiry;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id
    private String studentId;
    private String studentName;
    private String studentEmail;
    @OneToMany
    private List<Classroom> classrooms;
}
