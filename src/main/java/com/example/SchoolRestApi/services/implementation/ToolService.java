package com.example.SchoolRestApi.services.implementation;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ToolService {
    public int getAgeFromBirthDate(String birthdate){
        LocalDate curDate = LocalDate.now();
        return Period.between(LocalDate.parse(birthdate), curDate).getYears();
    };

    public int calculateAge(String date){
        LocalDate curDate = LocalDate.now();
        LocalDate parsedDate = LocalDate.parse(date);
        return (Period.between(parsedDate, curDate).getYears());
    }

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
