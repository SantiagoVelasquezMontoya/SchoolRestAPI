package com.example.SchoolRestApi.controllers;

import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.services.IAssignatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignature")
public class AssignatureController {


    public final IAssignatureService iassignatureService;

    public AssignatureController(IAssignatureService iassignatureService) {
        this.iassignatureService = iassignatureService;
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
            return ResponseEntity.ok().body(iassignatureService.saveAssignature(assignature));
        }
        catch(Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/teacher")
    public ResponseEntity<String> saveTeacher(@RequestBody saveTeacherRequest request){
        try{
            return  ResponseEntity.ok().body(iassignatureService.saveTeacher(request.teacherId, request.assignatureId));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    record saveTeacherRequest (
            Integer teacherId,
            Integer assignatureId
    ){}
}
