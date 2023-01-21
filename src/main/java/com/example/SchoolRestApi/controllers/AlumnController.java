package com.example.SchoolRestApi.controllers;


import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.services.IAlumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.ExportException;
import java.util.List;

@RestController
@RequestMapping("/alumni")
public class AlumnController {


    @Autowired
    public final IAlumnService iAlumnService;

    public AlumnController(IAlumnService iAlumnService) {
        this.iAlumnService = iAlumnService;
    }

    @GetMapping()
    public ResponseEntity<List<AlumnDTO>> getAll(){
        try{
            return ResponseEntity.ok()
                    .body(iAlumnService.getAll());
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<String> saveAlumni(@RequestBody AlumnDTO alumn){
        try{
            return ResponseEntity.ok().body(iAlumnService.save(alumn));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAlumn(@RequestBody AlumnDTO alumn){
        try{
            return ResponseEntity.ok(iAlumnService.delete(alumn));
        }
         catch (Exception e){
            return ResponseEntity.notFound().build();
         }
    }

    @PutMapping()
    public ResponseEntity<String> updateAlumn(@RequestBody AlumnDTO alumn){
        try{
            return ResponseEntity.ok().body(iAlumnService.update(alumn));
        }
         catch (Exception e){
            return ResponseEntity.notFound().build();
         }
    }

    @PutMapping("/enroll")
    public ResponseEntity<String> enrollALumn(@RequestBody AlumnDTO alumn){
        try{
            return ResponseEntity.ok().body(iAlumnService.enroll(alumn));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
