package com.companyaccounting.service;


import com.companyaccounting.dto.FileUploadResponse;
import com.companyaccounting.entity.User;
import com.companyaccounting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;

@Service
public class FileStorageService {

    private Path fileStoragePath;
    //private Path docFileStoragePath;
    private Path docFileStoragePath;

    private final UserRepository userRepository;

    private boolean imgflag = false;

    private boolean docflag = false;
    /* private String fileStorageLocation;*/

    public FileStorageService(@Value("${file.storage.location:temp}") String fileStorageLocation, @Value("${file.storage.docLocation:temp}") String docFileStorageLocation, UserRepository userRepository) {

        /*this.fileStorageLocation = fileStorageLocation;*/
        fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();

        docFileStoragePath = Paths.get(docFileStorageLocation).toAbsolutePath().normalize();

       /* try {

            Files.createDirectories(fileStoragePath);

            Files.createDirectories(docFileStoragePath);

        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory");
        }*/
        this.userRepository = userRepository;
    }


    public Set<String> storeFile(MultipartFile imgFile, MultipartFile docFile) {
        Set<String> existingFileName = new HashSet<>();
        String imgFileName = StringUtils.cleanPath(imgFile.getOriginalFilename());
        String docFileName = StringUtils.cleanPath(docFile.getOriginalFilename());
        try {

            if (!imgFile.isEmpty() && imgFileName.endsWith(".jpg") || imgFileName.endsWith(".png")) {
                if (!imgflag) {
                    Files.createDirectories(fileStoragePath);
                    saveImage(imgFile,imgFileName, existingFileName);
                    imgflag = true;
                } else {
                    saveImage(imgFile,imgFileName, existingFileName);
                }
            }
            if (!docFile.isEmpty() && docFileName.endsWith(".pdf")) {
                if (!docflag) {
                    Files.createDirectories(docFileStoragePath);
                    saveDocument(docFile, docFileName, existingFileName);
                    docflag = true;
                } else {
                    saveDocument(docFile, docFileName, existingFileName);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Issue in storing the file");
        }
        return existingFileName;
    }

    private void saveImage(MultipartFile imgFile, String imgFileName, Set<String> existingFileName) throws IOException {
        Path filePath = Paths.get(fileStoragePath + "\\" + imgFileName);
        Files.copy(imgFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        existingFileName.add(imgFileName);
    }
    private void saveDocument(MultipartFile docFile, String docFileName, Set<String> existingFileName) throws IOException {
        Path docFilePath = Paths.get(docFileStoragePath + "\\" + docFileName);
        Files.copy(docFile.getInputStream(), docFilePath, StandardCopyOption.REPLACE_EXISTING);
        existingFileName.add(docFileName);
    }

    /* public Resource downloadFile(String fileName) {

        Path path = Paths.get(fileStorageLocation).toAbsolutePath().resolve(fileName);
        Resource resource;

        try {
            resource = new UrlResource(path.toUri());

        } catch (MalformedURLException e) {
            throw new RuntimeException("Issue in reading the file",e);
        }

        if(resource.exists() && resource.isReadable){
            return resource;
        }else {
            throw new RuntimeException("the file doesn't exist or not eadable");
        }
    }*/
}
