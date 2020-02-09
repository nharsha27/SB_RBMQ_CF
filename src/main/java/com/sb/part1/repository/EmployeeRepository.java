package com.sb.part1.repository;

import com.sb.part1.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {


    EmployeeEntity findByFirstName(String name);


}
