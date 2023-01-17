package com.example.lyceumapi.service;


import com.example.lyceumapi.dto.DocumentDto;
import com.example.lyceumapi.entity.Document;
import com.example.lyceumapi.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document save(DocumentDto documentDto) {
        Document document = new Document()
                .setDocType(documentDto.getDocType())
                .setDocument(documentDto.getDocument())
                .setId(UUID.randomUUID().toString())
                .setCreatedAt(LocalDateTime.now());
        return documentRepository.save(document);
    }

    public List<Document> getAll() {
        return documentRepository.findAll();
    }

}
