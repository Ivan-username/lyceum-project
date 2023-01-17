package com.example.lyceumapi.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private String name;
    private LocalDate birthDay;
}
