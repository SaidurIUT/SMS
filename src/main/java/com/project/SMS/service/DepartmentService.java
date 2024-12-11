package com.project.SMS.service;

import com.project.SMS.payloads.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long id);
    List<DepartmentDto> getAllDepartments();
    void deleteDepartment(Long id);
}