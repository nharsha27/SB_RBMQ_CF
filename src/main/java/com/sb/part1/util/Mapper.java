package com.sb.part1.util;

import com.sb.part1.entity.AddressEntity;
import com.sb.part1.entity.EmployeeEntity;
import com.sb.part1.model.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {


    public EmployeeEntity mapEmployeeDTOtoEmployeeEntity(EmployeeDTO employeeDTO) {
        AddressEntity addressEntity = AddressEntity.builder().
                houseNumber(employeeDTO.getAddressEntity().getHouseNumber()).
                society(employeeDTO.getAddressEntity().getSociety()).
                city(employeeDTO.getAddressEntity().getCity()).
                country(employeeDTO.getAddressEntity().getCountry()).
                pincode(employeeDTO.getAddressEntity().getPincode()).build();

        return EmployeeEntity.builder().
                firstName(employeeDTO.getFirstName()).
                lastName(employeeDTO.getLastName()).
                emailAddress(employeeDTO.getEmailAddress()).
                addressEntity(addressEntity).build();


    }
}
