package com.classroom;

import com.classroom.Entiry.Student;
import com.classroom.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClassroomApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassroomApiApplication.class, args);
    }
}
