package com.classroom.Entiry;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id
    private String classroomId;
    private String classroomName;
    @ManyToMany
    private List<Student> enrolledStudents;
    @OneToMany
    private List<Tasks> tasks;
    @ManyToOne
    private Teacher teacher;
}
