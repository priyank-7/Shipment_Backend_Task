package com.classroom.Entiry;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classroom {
    @Id
    private String classroomId;
    @Column(unique = true)
    private String classroomName;
    @ManyToMany
    private List<Student> enrolledStudents;
    @OneToMany
    private List<Tasks> tasks;
    @ManyToOne
    private Teacher teacher;
}
