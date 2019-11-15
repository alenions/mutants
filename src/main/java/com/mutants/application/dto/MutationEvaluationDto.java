package com.mutants.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MutationEvaluationDto{
    @JsonProperty("dna")
    public String[] dna;
}
