package com.emp.EmployeManagementSystem.Service;

import com.emp.EmployeManagementSystem.EmployeeDTO;
import com.emp.EmployeManagementSystem.Entity.EmployeeEntity;
import com.emp.EmployeManagementSystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO getEmployee(Long id) {
        Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(id);
        EmployeeEntity emp = employeeEntity.get();
        return new EmployeeDTO(
                emp.getId(),
                emp.getEmpCode(),
                emp.getName(),
                emp.getEmail(),
                emp.getDepartment(),
                emp.getSalary()
        );
    }

    @Override
    public String createEmployee(EmployeeDTO employee) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employee.name());
        employeeEntity.setEmpCode(employee.empCode());
        employeeEntity.setDepartment(employee.department());
        employeeEntity.setEmail(employee.email());
        employeeEntity.setSalary(employee.salary());
        employeeRepository.save(employeeEntity);


        return "Employee Created Successfully........";
    }
}
