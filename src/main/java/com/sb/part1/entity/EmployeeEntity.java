package com.sb.part1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    @Email
    private  String emailAddress;

 //   @OneToOne(mappedBy = "EmployeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToOne(mappedBy = "employeeEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
   private AddressEntity addressEntity;


}
