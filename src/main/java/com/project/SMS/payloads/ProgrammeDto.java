package com.project.SMS.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgrammeDto {

    private Long id;
    private String name;
    private String description;
    private Long departmentId; // Assuming that the department's ID will be passed as part of the DTO
}
