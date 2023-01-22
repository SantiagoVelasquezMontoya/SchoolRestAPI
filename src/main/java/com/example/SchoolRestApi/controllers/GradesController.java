package com.example.SchoolRestApi.controllers;

import com.example.SchoolRestApi.dto.GradesDTO;
import com.example.SchoolRestApi.services.IGradesService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/grades")
public class GradesController {

    private final IGradesService igradesService;

    public GradesController(IGradesService igradesService) {
        this.igradesService = igradesService;
    }

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

    @PostMapping
    public ResponseEntity<?> saveGrading(@Valid @RequestBody GradesDTO grades){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(igradesService.saveGrade(grades));
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getGrades(){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(igradesService.getAllGrades());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
