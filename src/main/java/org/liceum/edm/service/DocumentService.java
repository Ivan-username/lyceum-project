package org.liceum.edm.service;


import org.liceum.edm.dto.DocumentDto;
import org.liceum.edm.entity.DocumentEntity;
import org.liceum.edm.entity.UserEntity;
import org.liceum.edm.repository.DocumentRepository;
import org.liceum.edm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentService {

    private final UserRepository userRepository;
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(UserRepository userRepository, DocumentRepository documentRepository) {
        this.userRepository = userRepository;
        this.documentRepository = documentRepository;
    }

    @Transactional
    public DocumentEntity save(DocumentDto documentDto) {
        UserEntity user = userRepository
                .findById(documentDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Unknown user"));

        DocumentEntity documentEntity = new DocumentEntity()
                .setDocumentId(UUID.randomUUID().toString())
                .setDocType(documentDto.getDocType())
                .setDocumentRef(documentDto.getDocumentRef())
                .setUser(user)
                .setCreatedAt(LocalDateTime.now());
        return documentRepository.save(documentEntity);
    }

    public List<DocumentEntity> getAll() {
        return documentRepository.findAll();
    }

}

