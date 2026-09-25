package com.emp.EmployeManagementSystem.Repository;

import com.emp.EmployeManagementSystem.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
