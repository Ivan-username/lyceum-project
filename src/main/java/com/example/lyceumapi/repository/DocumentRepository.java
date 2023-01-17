package com.example.lyceumapi.repository;

import com.example.lyceumapi.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {
}
