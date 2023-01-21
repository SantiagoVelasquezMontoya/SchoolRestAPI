package com.example.SchoolRestApi.services;

import com.example.SchoolRestApi.dto.AlumnDTO;
import org.springframework.stereotype.Service;


import java.util.List;
public interface IAlumnService {

    String save(AlumnDTO alumn);
    String update(AlumnDTO alumn);
    String delete(AlumnDTO alumn);
    List<AlumnDTO> getAll();
    String enroll(AlumnDTO alumn);

}
