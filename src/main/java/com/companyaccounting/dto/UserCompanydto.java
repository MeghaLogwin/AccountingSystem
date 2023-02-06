package com.companyaccounting.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCompanydto {
    private Long companyId;
    private String name;
    private String password;
    private String emailId;
    private String designation;
    private String department;
    private String contactNumber;
    private String joiningDate;
    private String gender;
    private String dateOfBirth;
    private double salary;
    private String photo;
    private String document;
}
