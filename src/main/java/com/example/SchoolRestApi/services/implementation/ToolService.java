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

    public boolean isValidDate(LocalDate date){
        //^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$
        return date.toString().matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$");
    }
}
