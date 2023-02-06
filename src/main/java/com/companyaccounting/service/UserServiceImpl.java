package com.companyaccounting.service;

import com.companyaccounting.dto.FileUploadResponse;
import com.companyaccounting.dto.UserCompanydto;
import com.companyaccounting.entity.User;
import com.companyaccounting.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserCompanydto saveUserToCompany(HashMap<String, Object> formData, MultipartFile imgFile,MultipartFile docFile) throws Exception {

        UserCompanydto dto = new UserCompanydto();
        // for Saving image file
        Set<String> fileNames = fileStorageService.storeFile(imgFile,docFile);


        //http://localhost:8080/download/abc.jpg
        fileNames.stream().forEach(fileName -> {
            String contentType = null;
            String url= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download")
                    .path(fileName)
                    .toUriString();

            if(fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
//                contentType = imgFile.getContentType();
                FileUploadResponse response = new FileUploadResponse();
                response.setFileName("imageFile");
                String imagename = response.getFileName();
                dto.setPhoto(imagename);
            }
            if(fileName.endsWith(".pdf")) {
//                contentType = docFile.getContentType();
                FileUploadResponse response = new FileUploadResponse();
                response.setFileName("documentFile");
                String docname = response.getFileName();
                dto.setDocument(docname);
            }
            if(!fileName.endsWith(".jpg")|| !fileName.endsWith(".png") || !fileName.endsWith(".pdf")){
                System.out.println("Invalid File Type");
            }
        });

        formData.entrySet().stream().forEach(record -> {
            if (record.getKey().equals("companyId")) {
                dto.setCompanyId(Long.valueOf((String) record.getValue()));
            } else if (record.getKey().equals("name")) {
                dto.setName((String) record.getValue());
            } else if (record.getKey().equals("password")) {
                dto.setPassword((String) record.getValue());
            } else if (record.getKey().equals("emailId")) {
                dto.setEmailId((String) record.getValue());
            } else if (record.getKey().equals("designation")) {
                dto.setDesignation((String) record.getValue());
            } else if (record.getKey().equals("department")) {
                dto.setDepartment((String) record.getValue());
            } else if (record.getKey().equals("contactNumber")) {
                dto.setContactNumber((String) record.getValue());
            } else if (record.getKey().equals("joiningDate")) {
                dto.setJoiningDate((String) record.getValue());
            } else if (record.getKey().equals("gender")) {
                dto.setGender((String) record.getValue());
            } else if (record.getKey().equals("dateOfBirth")) {
                dto.setDateOfBirth((String) record.getValue());
            } else if (record.getKey().equals("salary")) {
                dto.setSalary(Double.valueOf((String) record.getValue()));
            } else if (record.getKey().equals("photo")) {
                dto.setPhoto((String) record.getValue());
            }else if (record.getKey().equals("document")) {
                dto.setDocument((String) record.getValue());
            } else {
                throw new NullPointerException();
            }
        });

        UserCompanydto dto1 = new UserCompanydto();
        User users = convertDtoToEntity(dto);

        if (!ObjectUtils.isEmpty(users)) {
            User userEntitty = userRepository.save(users);
            return convertEntityToDTO(userEntitty);
        }
        return dto1;
    }

    public User convertDtoToEntity(UserCompanydto userCompanydto){
        //convert UserDto to User Entity
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        User user = modelMapper.map(userCompanydto, User.class);
        return user;
    }

    public UserCompanydto convertEntityToDTO(User user){
        //convert User Entity to UserDto
        UserCompanydto userCompanydto = this.modelMapper.map(user, UserCompanydto.class);
        return userCompanydto;
    }

    public FileUploadResponse storeFileNameToPhoto(String filename){

        FileUploadResponse response = new FileUploadResponse();
        String name = response.getFileName();

        return response;
    }
}
