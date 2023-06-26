package com.example.tryapp.service;

import com.example.tryapp.common.ResponseMapping;
import com.example.tryapp.common.Status;
import com.example.tryapp.exception.NotFoundException;
import com.example.tryapp.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import com.example.tryapp.model.Students;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.tryapp.repo.StudentRepo;

import java.nio.channels.NotYetBoundException;
import java.util.List;
import java.util.Optional;

import static com.example.tryapp.common.StatusCode.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final JwtUtils jwtUtils;
//    private final PasswordEncoder passwordEncoder;

    public Students addstud(Students students) {
        return studentRepo.save(students);
    }

    public Status update(Students students) throws NotFoundException {
        Students student = studentRepo.findById(students.getName())
                .orElseThrow(()->new NotFoundException("Name not Found"));
        if (students.getName().equals(student.getName())) {
            student.setDOB(students.getDOB());
            student.setPhone_number(students.getPhone_number());
            studentRepo.save(student);
            return ResponseMapping.INSTANCE.baseMapping(RECORD_UPDATED_SUCCESSFULLY," ok");
        }
        return ResponseMapping.INSTANCE.baseMapping(RECORD_DOESNT_EXIST,"ok");
    }

    public String delete(String Id) {
        Students student = studentRepo.findById(Id).orElse(null);
        if (Id.equals(student.getName())) {
            studentRepo.deleteById(Id);
            return "Deleted Successfully";
        }
        return "User Not Found ";
    }

    public List<Students> getStud() {
        return studentRepo.findAll();
    }

    public Status signUp(Students students) throws NotFoundException {
        Optional<Students> student = studentRepo.findById(students.getName());

//        if(students.getName().equals(studentRepo.findByName(students.getName())))
            if (students.getName().equals(student.getName())) {
            return ResponseMapping.INSTANCE.baseMapping(RECORD_ALREADY_EXIST,"ok");
        }
        studentRepo.save(students);
        return  ResponseMapping.INSTANCE.baseMapping(RECORD_UPDATED_SUCCESSFULLY,"ok");
    }

    public Status login(Students students) throws NotFoundException {
        Students students1= studentRepo.
                findOneByNameAndPassword(students.getName(), students.getPassword())
                .orElseThrow(() -> new NotFoundException("signin Before Login"));
        String token=jwtUtils.tokenGenerate(students);
            return ResponseMapping.INSTANCE.baseMapping(LOGIN,token);
    }
}
