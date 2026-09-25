package com.emp.EmployeManagementSystem.Service;

import com.emp.EmployeManagementSystem.EmployeeDTO;

public interface IEmployeeService {

    public EmployeeDTO getEmployee(Long id);
    public String createEmployee(EmployeeDTO employee);
}
