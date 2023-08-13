package com.example.schoolmanagement.Controller;


import com.example.schoolmanagement.ApiRespoens.ApiRespoens;
import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Serviec.StudentServiec;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiec studentServiec;


    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(studentServiec);
    }

    @PostMapping("/add")
    public ResponseEntity addStudents(@RequestBody @Valid Student student , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentServiec.addStudent(student);
        return ResponseEntity.status(200).body(new ApiRespoens("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudents(@PathVariable String id , @RequestBody @Valid Student student , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate =studentServiec.updateStudent(id,student);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Check the id"));
    }


   @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudents(@PathVariable String id){
        boolean d=studentServiec.DeleteStudent(id);
        if(d){
            return ResponseEntity.status(200).body(new ApiRespoens("Student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Check the id"));
    }


    @GetMapping("/getstudent/{id}")
        public ResponseEntity getstudent(@PathVariable String id){
        Student s =studentServiec.getStudent(id);
        if(s!=null){
        return ResponseEntity.status(200).body(s);}
        return ResponseEntity.status(400).body(new ApiRespoens("not found"));
    }









}
