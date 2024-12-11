package com.project.SMS.controller;


import com.project.SMS.payloads.ProgrammeDto;
import com.project.SMS.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programmes")
public class ProgrammeController {

    private final ProgrammeService programmeService;

    @Autowired
    public ProgrammeController(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }

    @PostMapping
    public ResponseEntity<ProgrammeDto> createProgramme(@RequestBody ProgrammeDto programmeDto) {
        ProgrammeDto createdProgramme = programmeService.createProgramme(programmeDto);
        return new ResponseEntity<>(createdProgramme, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammeDto> getProgrammeById(@PathVariable Long id) {
        ProgrammeDto programmeDto = programmeService.getProgrammeById(id);
        return new ResponseEntity<>(programmeDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProgrammeDto>> getAllProgrammes() {
        List<ProgrammeDto> programmes = programmeService.getAllProgrammes();
        return new ResponseEntity<>(programmes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammeDto> updateProgramme(@PathVariable Long id, @RequestBody ProgrammeDto programmeDto) {
        ProgrammeDto updatedProgramme = programmeService.updateProgramme(id, programmeDto);
        return new ResponseEntity<>(updatedProgramme, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramme(@PathVariable Long id) {
        programmeService.deleteProgramme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
