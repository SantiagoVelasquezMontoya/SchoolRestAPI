package com.example.SchoolRestApi.services.implementation;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ToolService {
    public int getAgeFromBirthDate(LocalDate birthdate){
        LocalDate curDate = LocalDate.now();
        return Period.between(birthdate, curDate).getYears();
    };
}
