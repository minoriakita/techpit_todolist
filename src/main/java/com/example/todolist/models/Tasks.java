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
    @Size(max = 120)
    private String title;

    @Size(max = 120)
    // @Min(0)
    // @Max(120)
    private String detail;

    private int flag;

    // private String time_limit;

    // public void setDate(int i) {
    // }

    // public void setDate(String string) {
    // }

    // @NotBlank
    // @Email
    // @Size(max = 254)
    // private String email;

    // public String getName() {
    //     return this.name;
    // }

    // public Integer getAge() {
    //     return this.age;
    // }

    // public String getEmail() {
    //     return this.email;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setAge(Integer age) {
    //     this.age = age;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }
}
