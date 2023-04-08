package org.liceum.edm.controllers;

import org.liceum.edm.dto.DocumentDto;
import org.liceum.edm.entity.DocumentEntity;
import org.liceum.edm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("api/v1/documents")
public class ClientController {

    private final DocumentService service;

    @Value("${service.pathToFile:C:/user.ivan/lyceum_homework/Project/Files/}")
    private String pathToFile;

    @Autowired
    public ClientController(DocumentService service) {
        this.service = service;
    }

    @PostMapping("save")
    public DocumentEntity save(@RequestBody DocumentDto documentDto) {
        return service.save(documentDto);
    }

    @GetMapping("getAll")
    public List<DocumentEntity> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody
    String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(@RequestParam("docType") String docType,
                            @RequestParam("userId") String userId,
                            @RequestParam("file") MultipartFile file) {


//        String userId = "1";
        //String docType = "passport";

        //final String pathToFile = "C:/user.ivan/lyceum_homework/Project/Files/"; //TODO                    ---------- HARDCODE ----------
        final String fileName = file.getOriginalFilename();
        final String fullPathToFile = pathToFile + fileName;


        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                OutputStream stream = new BufferedOutputStream(new FileOutputStream(fullPathToFile));
                stream.write(bytes);
                stream.close();

                service.save(DocumentDto
                        .builder()
                        .userId(userId)
                        .docType(docType)
                        .documentRef(fullPathToFile)
                        .build()
                );

                return "Вы удачно загрузили " + fileName + " в " + pathToFile;
            } catch (Exception e) {
                return "Вам не удалось загрузить " + fileName + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + fileName + " потому что файл пустой.";
        }
    }

}
