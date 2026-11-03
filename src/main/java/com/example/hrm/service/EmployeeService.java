package com.example.hrm.service;

import com.example.hrm.dto.EmployeeCreatedDTO;
import com.example.hrm.entity.Department;
import com.example.hrm.entity.Employee;
import com.example.hrm.repository.DepartmentRepository;
import com.example.hrm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(EmployeeCreatedDTO dto) {
        // Tìm phòng ban theo ID truyền lên từ DTO
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng ban với ID: " + dto.getDepartmentId()));

        // Chuyển đổi từ DTO sang Entity
        Employee employee = new Employee();
        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }
}