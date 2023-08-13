package com.example.schoolmanagement.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    //Teacher Class : ID , name , salary ( all should not be empty).

    @NotEmpty(message = "This fields is required")
    private String id;

    @NotEmpty(message = "This fields is required")
    private String name;

    @NotNull(message = "This fields is required")
    private Integer salary;


}
