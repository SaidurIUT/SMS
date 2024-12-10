package com.project.SMS.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AdminInfoDto {

    private Long id;

    private String adminLevel;

    private String departmentManaged;

    private Long userId; // Reference to the associated User entity
}
