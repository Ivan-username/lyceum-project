package com.example.lyceumapi.controllers;

import com.example.lyceumapi.dto.DocumentDto;
import com.example.lyceumapi.entity.Document;
import com.example.lyceumapi.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class FileUploadController {

    private final DocumentService service;

    @Autowired
    public FileUploadController(DocumentService service) {
        this.service = service;
    }

    @PostMapping("save")
    public Document save(@RequestBody DocumentDto document) {
        return service.save(document);
    }
    @GetMapping("getAll")
    public List<Document> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {

        final String pathToFile = "C:/user.ivan/lyceum_homework/Project/Files/"; //TODO                    ---------- HARDCODE ----------
        final String fileName = file.getOriginalFilename();
        final String fullPathToFile = pathToFile + fileName;



        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                OutputStream stream = new BufferedOutputStream(new FileOutputStream(fullPathToFile));
                stream.write(bytes);
                stream.close();
                return "Вы удачно загрузили " + fileName + " в " + pathToFile;
            } catch (Exception e) {
                return "Вам не удалось загрузить " + fileName + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + fileName + " потому что файл пустой.";
        }
    }

}
