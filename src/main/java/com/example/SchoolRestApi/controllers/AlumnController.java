package com.example.SchoolRestApi.controllers;


import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.services.IAlumnService;
import com.example.SchoolRestApi.services.implementation.ValidationHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
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
@RequestMapping("/alumni")
@Validated
public class AlumnController {

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

    public final IAlumnService iAlumnService;

    public AlumnController(IAlumnService iAlumnService) {
        this.iAlumnService = iAlumnService;
    }



    @GetMapping()
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok()
                    .body(iAlumnService.getAll());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping()
    public ResponseEntity<?> saveAlumni(@Valid @RequestBody AlumnDTO alumn){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(iAlumnService.save(alumn));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
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
