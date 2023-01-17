package com.example.lyceumapi.dto;

import lombok.Data;

import java.io.File;

@Data
public class DocumentDto {
    String docType;
    File document;
}
