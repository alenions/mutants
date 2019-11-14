package com.mutants.application.service.impl;

import com.mutants.application.dto.MutantGenDto;
import com.mutants.application.service.IMutantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MutantService implements IMutantService{

    @Autowired
    private MutantGenDto mutantGenDto;

    @Bean
    public MutantGenDto getArrayVertical(){
        MutantGenDto mutantGenDto = new MutantGenDto();
        mutantGenDto.setDnaVertical(new String[] {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        mutantGenDto.setDnaHorizontal(new String[] {"ACTACT","TATGCC","GGAACA","CTTACC","GGGGTT","ACTGAG"});
        mutantGenDto.setDnaDiagonal(new String[] {"ACTACT","TATGCC","GGAACA","CTTACC","GGGGTT","ACTGAG"});
        return mutantGenDto;
    }

    public boolean isMutant(String[] dna){
        boolean isMutant = false;

        int valueHorizontal = 0;
        int valueVertical = 0;
        int valueDiagonal = 0;
        int countFound = 0;

        for(String nitrogenousSubject : dna){
            try{
                for(String nitrogenousMutant: mutantGenDto.getDnaHorizontal()){
                    if(nitrogenousMutant.contains(nitrogenousSubject.substring(valueHorizontal,valueHorizontal+4))){
                        countFound++;
                        break;
                    }else{
                        valueHorizontal++;
                    }
                }
            }catch(StringIndexOutOfBoundsException e){
                log.error("nitrogenousSubject out range. ");
            }finally{
                valueHorizontal = 0;
            }

            try{
                for(String nitrogenousMutant: mutantGenDto.getDnaVertical()){
                    if(nitrogenousMutant.contains(nitrogenousSubject.substring(valueVertical,valueVertical+4))){
                        countFound++;
                        break;
                    }else{
                        valueVertical++;
                    }
                }
            }catch(StringIndexOutOfBoundsException e){
                log.error("nitrogenousSubject out range. ");
            }finally{
                valueVertical = 0;
            }

            if(countFound == 2){
                return true;
            }
        }
        return isMutant;
    }
}
