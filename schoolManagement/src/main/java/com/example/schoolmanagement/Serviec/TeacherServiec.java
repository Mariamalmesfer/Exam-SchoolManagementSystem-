package com.example.schoolmanagement.Serviec;

import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherServiec {


    ArrayList<Teacher> teachers = new ArrayList<>();


    public ArrayList<Teacher> getTeacher(){
        return teachers;
    }

    public void  addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public Boolean UpdateTeacher(String id, Teacher teacher){
        for (int i =0 ;i<teachers.size();i++){
            if( teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }


    public Boolean DeleteTeacher(String id){
        for (int i =0 ;i<teachers.size();i++){
            if( teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }


    public Teacher getTeacher(String id){
        for (int i =0 ;i<teachers.size();i++){
            if( teachers.get(i).getId().equals(id)){
                return teachers.get(i);
            }
        }
        return null;
    }














}
