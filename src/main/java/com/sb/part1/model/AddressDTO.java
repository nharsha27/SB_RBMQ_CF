package com.sb.part1.model;

import com.sb.part1.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private String addressId;

    private EmployeeEntity employeeEntity;

    private String houseNumber;

    private String society;

    private String city;

    private String country;

    private String pincode;

}
