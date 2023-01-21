package com.example.SchoolRestApi.controllers;

import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.ITeacherRepository;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.services.IAssignatureService;
import com.example.SchoolRestApi.services.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignature")
public class AssignatureController {


    public final IAssignatureService iassignatureService;
    public final ITeacherService iTeacherService;

    public AssignatureController(IAssignatureService iassignatureService, ITeacherService iTeacherService) {
        this.iassignatureService = iassignatureService;
        this.iTeacherService = iTeacherService;
    }

    @GetMapping()
    public ResponseEntity<List<AssignatureDTO>> getAll(){
        try{
            return ResponseEntity.ok().body(iassignatureService.getAssignatures());
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<String> saveAssignature(@RequestBody AssignatureDTO assignature){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(iassignatureService.saveAssignature(assignature));
        }
        catch(Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateAssignature(@RequestBody AssignatureDTO assignature){
        try{
            return ResponseEntity.ok().body(iassignatureService.updateAssignature(assignature));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAssignature(@RequestBody AssignatureDTO assignature){
        try{
            return ResponseEntity.ok().body(iassignatureService.deleteAssignature(assignature));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}
