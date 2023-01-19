package com.example.SchoolRestApi.controllers;


import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.services.ITeacherService;
import com.example.SchoolRestApi.services.implementation.ITeacherServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    public final ITeacherService iTeacherService;



    public TeacherController(ITeacherService iTeacherService) {
        this.iTeacherService = iTeacherService;
    }

    @GetMapping()
    public ResponseEntity<List<TeacherDTO>> getAll(){
        try{
            return ResponseEntity.ok()
                    .body(iTeacherService.getAll());
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<String> saveAlumni(@RequestBody TeacherDTO teacher){
        try{
            return ResponseEntity.ok().body(iTeacherService.save(teacher));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAlumn(@RequestBody TeacherDTO teacher){
        try{
            return ResponseEntity.ok(iTeacherService.delete(teacher));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateAlumn(@RequestBody TeacherDTO teacher){
        try{
            return ResponseEntity.ok().body(iTeacherService.update(teacher));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
