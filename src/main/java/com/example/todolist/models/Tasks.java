package com.example.todolist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.validation.constraints.Min;
// import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
 import lombok.Setter;
 @Getter
 @Setter
 @Entity
public class Tasks {
    @Id
    @GeneratedValue
    private Long id;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private String date;

    @NotBlank
    @Size(max = 50)
    private String title;

    @Size(max = 100)
    private String detail;

    private int flag;
}
