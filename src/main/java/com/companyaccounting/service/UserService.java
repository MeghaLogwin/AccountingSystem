package com.companyaccounting.service;

import com.companyaccounting.dto.UserCompanydto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public interface UserService {
    public UserCompanydto saveUserToCompany(HashMap<String, Object> formData,MultipartFile imgFile,MultipartFile docFile) throws Exception;

}
