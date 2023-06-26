package com.example.tryapp.controller;

import com.example.tryapp.common.Status;
import com.example.tryapp.exception.NotFoundException;
import com.example.tryapp.security.JwtUtils;
import com.example.tryapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import com.example.tryapp.model.Students;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stud")
public class StudentControl {

    private final StudentService studentService;
    private final JwtUtils jwtUtils;

    @PostMapping("/signUp")
    public ResponseEntity<Status> signUp(@RequestBody Students students) throws NotFoundException {
        return ResponseEntity.ok(studentService.signUp(students));
    }
    @SneakyThrows
    @PostMapping("/login")
    public ResponseEntity<Status> login(@RequestBody Students students)   {
        return ResponseEntity.ok(studentService.login(students));
    }
    @PostMapping("/add")
    public Students addStud(@RequestBody Students students){
        return studentService.addstud(students);
    }
    @SneakyThrows
    @PutMapping("/update")
    public ResponseEntity<Status> update(@RequestBody Students students)  {
        return ResponseEntity.ok(studentService.update(students));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(String Id){
        return ResponseEntity.ok(studentService.delete(Id));
    }
    @GetMapping("/getAllStud")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Students>> getStud(@RequestHeader(value = "auth",defaultValue = "") String auth)throws Exception{
        jwtUtils.verify(auth);
        return ResponseEntity.ok(studentService.getStud());
    }
}
