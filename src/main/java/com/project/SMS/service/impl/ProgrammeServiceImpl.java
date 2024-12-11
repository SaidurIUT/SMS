package com.project.SMS.service.impl;


import com.project.SMS.entities.Department;
import com.project.SMS.entities.Programme;
import com.project.SMS.payloads.ProgrammeDto;
import com.project.SMS.repository.DepartmentRepo;
import com.project.SMS.repository.ProgrammeRepo;
import com.project.SMS.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {

    private final ProgrammeRepo programmeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    public ProgrammeServiceImpl(ProgrammeRepo programmeRepo) {
        this.programmeRepo = programmeRepo;
    }

    @Override
    public ProgrammeDto createProgramme(ProgrammeDto programmeDto) {
        Programme programme = new Programme();
        programme.setName(programmeDto.getName());
        programme.setDescription(programmeDto.getDescription());

        Department department = departmentRepo.findById(programmeDto.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        programme.setDepartment(department);


        Programme savedProgramme = programmeRepo.save(programme);
        return new ProgrammeDto(savedProgramme.getId(), savedProgramme.getName(), savedProgramme.getDescription(), savedProgramme.getDepartment().getId());
    }

    @Override
    public ProgrammeDto getProgrammeById(Long id) {
        Programme programme = programmeRepo.findById(id).orElseThrow(() -> new RuntimeException("Programme not found"));
        return new ProgrammeDto(programme.getId(), programme.getName(), programme.getDescription(), programme.getDepartment().getId());
    }

    @Override
    public List<ProgrammeDto> getAllProgrammes() {
        return programmeRepo.findAll().stream()
                .map(programme -> new ProgrammeDto(programme.getId(), programme.getName(), programme.getDescription(), programme.getDepartment().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public ProgrammeDto updateProgramme(Long id, ProgrammeDto programmeDto) {
        Programme programme = programmeRepo.findById(id).orElseThrow(() -> new RuntimeException("Programme not found"));
        programme.setName(programmeDto.getName());
        programme.setDescription(programmeDto.getDescription());
        // Update department if necessary
        // programme.setDepartment(departmentRepository.findById(programmeDto.getDepartmentId()).orElseThrow(...));

        Programme updatedProgramme = programmeRepo.save(programme);
        return new ProgrammeDto(updatedProgramme.getId(), updatedProgramme.getName(), updatedProgramme.getDescription(), updatedProgramme.getDepartment().getId());
    }

    @Override
    public void deleteProgramme(Long id) {
        Programme programme = programmeRepo.findById(id).orElseThrow(() -> new RuntimeException("Programme not found"));
        programmeRepo.delete(programme);
    }
}
