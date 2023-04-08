//package org.liceum.edm.controllers;
//
//
//import org.liceum.edm.entity.DocumentEntity;
//import org.liceum.edm.service.DocumentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/documents")
//public class DocumentController {
//
//    private final DocumentService service;
//
//    @Autowired
//    public DocumentController(DocumentService service) {
//        this.service = service;
//    }
//
//    @GetMapping("getAll")
//    public List<DocumentEntity> getAll() {
//        return service.getAll();
//    }
//}
