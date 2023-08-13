package com.example.schoolmanagement.Serviec;

import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Model.Teacher;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentServiec {


    ArrayList<Student> students = new ArrayList<>();


    public ArrayList<Student> getStudents(){
        return students;
    }

    public void  addStudent(Student student){
        students.add(student);
    }

    public Boolean updateStudent(String id, Student student){
        for (int i =0 ;i<students.size();i++){
            if( students.get(i).getId().equals(id)){
                students.set(i,student);
                        return true;
            }
        }
        return false;
    }


    public Boolean DeleteStudent(String id){
        for (int i =0 ;i<students.size();i++){
            if( students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }



    public Student getStudent(String id){
        for (int i =0 ;i<students.size();i++){
            if( students.get(i).getId().equals(id)){
                return students.get(i);
            }
        }
        return null;
    }











}
