package com.companyaccounting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Owner_Tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private String email;
    private String password;
    private String phno;
    private int countryCode;
    private String registrationDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    private Set<Company> companies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    private Set<Department> departments;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "OWNER_PLANS",
            joinColumns = {
                @JoinColumn(name = "owner_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "plan_id", referencedColumnName = "id")
    })
    private Set<Plans> plans;
}
