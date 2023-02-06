package com.companyaccounting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class FileUploadResponse {

    private String fileName;
    private String fileType;
    private String downloadUrl;
}
