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

    public boolean isFullNameValid(String fullName){
        if(fullName.matches("[a-zA-Z]+")){
            return true;
        } else{
            return false;
        }
    }

    public boolean isAssignatureTopicValid(String topic){
       return topic.matches("^[aA-zZ0-9 ]{3,200}") ? true  : false;
    }
}
