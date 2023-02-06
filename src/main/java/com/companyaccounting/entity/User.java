package com.companyaccounting.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="User_Tb")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private  String document;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

}
