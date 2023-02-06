package com.companyaccounting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Plan_Tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String planName;
    private String planFeature;
    private String validity;
    private double fees;

    @JsonIgnore
    @ManyToMany(mappedBy = "plans",fetch = FetchType.LAZY)
    private Set<Owner> Owners;
}
