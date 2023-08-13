package com.example.schoolmanagement.Controller;


import com.example.schoolmanagement.ApiRespoens.ApiRespoens;
import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Serviec.StudentServiec;
import com.example.schoolmanagement.Serviec.TeacherServiec;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {




    private final TeacherServiec teacherServiec;


    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(teacherServiec);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherServiec.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiRespoens("Teachers added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeachers(@PathVariable String id , @RequestBody @Valid Teacher teacher  , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate =teacherServiec.UpdateTeacher(id,teacher);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("Teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Check the id"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeachers(@PathVariable String id){
        boolean d=teacherServiec.DeleteTeacher(id);
        if(d){
            return ResponseEntity.status(200).body(new ApiRespoens("Teacher deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Check the id"));
    }


    @GetMapping("/getteachers/{id}")
    public ResponseEntity getTeachers(@PathVariable String id){
        Teacher t =teacherServiec.getTeacher(id);
        if(t!=null){
            return ResponseEntity.status(200).body(t);}
        return ResponseEntity.status(400).body(new ApiRespoens("not found"));
    }


















}
