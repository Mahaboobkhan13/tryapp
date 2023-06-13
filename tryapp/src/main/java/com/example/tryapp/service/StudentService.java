package com.example.tryapp.service;

import lombok.RequiredArgsConstructor;
import com.example.tryapp.model.Students;
import org.springframework.stereotype.Service;
import com.example.tryapp.repo.StudentRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public Students addstud(Students students) {
        return studentRepo.save(students);
    }

    public Students update(Students students) {
        Students student = studentRepo.findById(students.getName()).orElse(null);
        if (students.getName().equals(student.getName())) {
            student.setDOB(students.getDOB());
            student.setSec(students.getSec());
            student.setPhone_number(students.getPhone_number());
            return studentRepo.save(student);
        }
        return null;
    }

    public String delete(String Id) {
        Students student = studentRepo.findById(Id).orElse(null);
        if (Id.equals(student.getName())) {
            studentRepo.deleteById(Id);
            return "Deleted Successfully";
        }
        return "User Not Found ";
    }
}
