package com.example.SchoolRestApi.services.implementation;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class ToolService {
    public int getAgeFromBirthDate(String birthdate){
        LocalDate curDate = LocalDate.now();
        return Period.between(LocalDate.parse(birthdate), curDate).getYears();
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

    public String changeDateFormat(String inputDate) throws ParseException {
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date alumniDate = originalDateFormat.parse(inputDate);
        String wantedDateFormat = outputDateFormat.format(alumniDate);

        return wantedDateFormat;

    }

}
