package com.example.schoolmanagement.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    // ID , name , age , major  ( all should not be empty)  .

     @NotEmpty(message = "This fields is required")
     private String id;

     @NotEmpty(message = "This fields is required")
    private String name;

    @NotNull(message = "This fields is required")
    private Integer age;

    @NotEmpty(message = "This fields is required")
    private String major;


}
