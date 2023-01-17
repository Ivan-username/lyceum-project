package com.example.lyceumapi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@Accessors(chain = true)
@Table(name = "documents")
public class Document {

    @Id
    private String id;
    private String docType;
    private File document;
    private LocalDateTime createdAt;

}
