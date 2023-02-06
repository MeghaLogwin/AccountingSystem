package com.companyaccounting.controller;

import com.companyaccounting.dto.FileUploadResponse;
import com.companyaccounting.service.FileStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//@RestController
public class UploadFileSystemController {

    /*private FileStorageService fileStorageService;

    public UploadFileSystemController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    FileUploadResponse fileUpload(@RequestParam("photo") MultipartFile file){

        String fileName = fileStorageService.storeFile(file);

        //http://localhost:8080/download/abc.jpg
        String url= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download")
                .path(fileName)
                .toUriString();

        String contentType = file.getContentType();
        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url);
        return response;
    }*/

    /*@GetMapping("/download/{fileName}")
    ResponseEntity<Resource>downloadSingleFile(@PathVariable String fileName){

        Resource resource = fileStorageService.downloadFile(fileName);

        MediaType contentType = MediaType.IMAGE_JPEG;

        return  ResponseEntity.ok()
                .contentType(contentType)
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;fileName="+resource.getName())
                .body(resource);
    }
*/
}
