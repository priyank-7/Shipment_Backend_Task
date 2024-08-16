package com.classroom.helpers;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String taskName;
    private String taskDescription;
    private Date dueDate;
}
