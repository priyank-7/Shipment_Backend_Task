package com.classroom.helpers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubmissionStatusDto {
    private String studentId;
    private String studentName;
    private String status;
}
