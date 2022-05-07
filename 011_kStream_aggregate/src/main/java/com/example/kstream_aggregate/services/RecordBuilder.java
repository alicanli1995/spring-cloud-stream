package com.example.kstream_aggregate.services;

import com.example.kstream_aggregate.DepartmentAggregate;
import com.example.kstream_aggregate.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RecordBuilder {

    public DepartmentAggregate init(){
        return DepartmentAggregate.newBuilder()
                .setEmployeeCount(0)
                .setTotalSalary(0)
                .setAvgSalary(0D).build();
    }

    public DepartmentAggregate aggregate(Employee employee , DepartmentAggregate departmentAggregate){
        return DepartmentAggregate.newBuilder()
                .setEmployeeCount(departmentAggregate.getEmployeeCount() + 1)
                .setTotalSalary(departmentAggregate.getTotalSalary() + employee.getSalary())
                .setAvgSalary((departmentAggregate.getAvgSalary() + employee.getSalary()) / departmentAggregate.getEmployeeCount() )
                .build();
    }

}
