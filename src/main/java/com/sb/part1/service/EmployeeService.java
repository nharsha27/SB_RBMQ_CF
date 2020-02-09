package com.sb.part1.service;


import com.sb.part1.entity.EmployeeEntity;
import com.sb.part1.model.EmployeeDTO;
import com.sb.part1.repository.EmployeeRepository;
import com.sb.part1.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Mapper employeeMapper;

    public void createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeMapper.mapEmployeeDTOtoEmployeeEntity(employeeDTO);
        employeeRepository.save(employeeEntity);
    }


}
