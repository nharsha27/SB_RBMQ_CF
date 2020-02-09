package com.sb.part1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity // table is created
@Data // getter and setter
@Builder // new not required
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    //@GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private EmployeeEntity employeeEntity;

    @Column
    private String houseNumber;

    @Column
    private String society;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String pincode;
}
