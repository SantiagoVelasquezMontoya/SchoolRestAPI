package com.example.SchoolRestApi.controllers;


import com.example.SchoolRestApi.dto.AlumnDTO;
import com.example.SchoolRestApi.dto.TeacherDTO;
import com.example.SchoolRestApi.services.ITeacherService;
import com.example.SchoolRestApi.services.implementation.ITeacherServiceImpl;
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
@RequestMapping("/teacher")
@Validated
public class TeacherController {

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
    public ResponseEntity<String> saveTeacher(@Valid @RequestBody TeacherDTO teacher){
        try{
            return ResponseEntity.ok().body(iTeacherService.save(teacher));
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteTeacher(@RequestBody TeacherDTO teacher){
        try{
            return ResponseEntity.ok(iTeacherService.delete(teacher));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateTeacher(@RequestBody TeacherDTO teacher){
        try{
            return ResponseEntity.ok().body(iTeacherService.update(teacher));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable Integer id){
        try{
            return ResponseEntity.ok().body(iTeacherService.getTeacher(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
