package com.starter.backend.controllers;

import com.starter.backend.models.File;
import com.starter.backend.services.FIleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {
    @Autowired
    private FIleService fIleService;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        try{
fIleService.storeFile(file);
return ResponseEntity.ok("File uploaded");
        }catch(IOException e){
            return ResponseEntity.status(500).body("error uploading file");
        }
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID id){
        File file = fIleService.getFile(id);
        if(file != null){
            return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file.getFile());
        }else{
            return ResponseEntity.status(404).body(null);
        }
    }
    @GetMapping("/preview/{id}")
    public ResponseEntity<byte[]> previewFile(@PathVariable UUID id) {
        File fileEntity = fIleService.getFile(id);

        if (fileEntity == null) {
            return ResponseEntity.notFound().build();
        }

        String filename = fileEntity.getFilename().toLowerCase();
        String contentType = "application/octet-stream";

        if (filename.endsWith(".png")) {
            contentType = MediaType.IMAGE_PNG_VALUE;
        } else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
            contentType = MediaType.IMAGE_JPEG_VALUE;
        } else if (filename.endsWith(".pdf")) {
            contentType = "application/pdf";
        } else if (filename.endsWith(".txt")) {
            contentType = MediaType.TEXT_PLAIN_VALUE;
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(fileEntity.getFile());
    }

}
