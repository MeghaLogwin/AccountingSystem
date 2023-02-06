package com.companyaccounting.controller;


import com.companyaccounting.dto.UserCompanydto;
import com.companyaccounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;


@RestController
@RequestMapping("/user/company")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveData")
    public UserCompanydto createUsers1(@RequestParam HashMap<String, Object> formData, @RequestParam("photo") MultipartFile imgFile, @RequestParam("document") MultipartFile docFile) throws Exception {
        return userService.saveUserToCompany(formData,imgFile,docFile);
    }
}
