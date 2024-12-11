package com.project.SMS.service;


import com.project.SMS.payloads.ProgrammeDto;

import java.util.List;

public interface ProgrammeService {
    ProgrammeDto createProgramme(ProgrammeDto programmeDto);
    ProgrammeDto getProgrammeById(Long id);
    List<ProgrammeDto> getAllProgrammes();
    ProgrammeDto updateProgramme(Long id, ProgrammeDto programmeDto);
    void deleteProgramme(Long id);
}