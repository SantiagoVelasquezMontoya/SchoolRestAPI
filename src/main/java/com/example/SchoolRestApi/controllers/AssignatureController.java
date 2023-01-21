package com.example.SchoolRestApi.controllers;

import com.example.SchoolRestApi.dto.AssignatureDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.repository.ITeacherRepository;
import com.example.SchoolRestApi.repository.entity.Assignature;
import com.example.SchoolRestApi.services.IAssignatureService;
import com.example.SchoolRestApi.services.ITeacherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assignature")
@Validated
public class AssignatureController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


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
    public ResponseEntity<?> saveAssignature(@Valid @RequestBody AssignatureDTO assignature){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(iassignatureService.saveAssignature(assignature));
        }
        catch(Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
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
