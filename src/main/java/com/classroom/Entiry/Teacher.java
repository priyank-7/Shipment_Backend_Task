package com.classroom.Entiry;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Teacher {

    @Id
    private String teacherId;
    private String password;
    private String teacherName;
    private String teacherEmail;
    private String teacherPhone;

    @ManyToMany
    private List<Classroom> classrooms;

}
