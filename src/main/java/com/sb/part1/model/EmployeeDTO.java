package com.sb.part1.model;


import com.sb.part1.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private String employeeId;

    private String firstName;

    private String lastName;

    private  String emailAddress;

    private AddressEntity addressEntity;

}
