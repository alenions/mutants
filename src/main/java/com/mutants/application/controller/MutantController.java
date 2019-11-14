package com.mutants.application.controller;

import com.mutants.application.dto.SubjectDto;
import com.mutants.application.service.IMutantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MutantController{

    @Autowired
    IMutantService mutantService;

    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(@RequestBody SubjectDto subjectDto){
        try{
            return mutantService.isMutant(subjectDto.getDna())?
                    new ResponseEntity<>(true, HttpStatus.OK):
                    new ResponseEntity<>(false, HttpStatus.FORBIDDEN) ;
        }catch(Exception e){
            log.error("General Error. ");
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}