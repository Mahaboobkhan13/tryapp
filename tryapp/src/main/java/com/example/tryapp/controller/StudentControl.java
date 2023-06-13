package com.example.tryapp.controller;

import com.example.tryapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import com.example.tryapp.model.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController("/stud")
public class StudentControl {

    private final StudentService studentService;

    @PostMapping("/add")
    public Students addStud(@RequestBody Students students){
        return studentService.addstud(students);
    }
    @PutMapping("/update")
    public Students update(@RequestBody Students students){
        return studentService.update(students);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(String Id){
        return ResponseEntity.ok(studentService.delete(Id));
    }
}
