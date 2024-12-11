package com.project.SMS.service.impl;

import com.project.SMS.entities.Department;
import com.project.SMS.payloads.DepartmentDto;
import com.project.SMS.repository.DepartmentRepo;
import com.project.SMS.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = mapToEntity(departmentDto);
        Department savedDepartment = departmentRepo.save(department);
        return mapToDto(savedDepartment);
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));

        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        Department updatedDepartment = departmentRepo.save(department);
        return mapToDto(updatedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
        return mapToDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepo.findAll();
        return departments.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
        departmentRepo.delete(department);
    }

    // Utility Methods
    private DepartmentDto mapToDto(Department department) {
        return new DepartmentDto(department.getId(), department.getName(), department.getDescription());
    }

    private Department mapToEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        return department;
    }
}
