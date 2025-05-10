package com.starter.backend.services;

import com.starter.backend.models.File;
import com.starter.backend.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FIleService {
    @Autowired
    private FileRepository fileRepository;
    public File storeFile(MultipartFile file) throws IOException {
      File newFile = new File();
      newFile.setFilename(file.getOriginalFilename());
      newFile.setFile(file.getBytes());
     return fileRepository.save(newFile);
    }
    public File getFile(UUID id){
        return fileRepository.findById(id).orElse(null);
    }

}
