package com.example.hrm.controller;

import com.example.hrm.dto.EmployeeCreatedDTO;
import com.example.hrm.entity.Employee;
import com.example.hrm.response.ApiResponse;
import com.example.hrm.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@Valid @RequestBody EmployeeCreatedDTO dto) {
        Employee savedEmployee = employeeService.createEmployee(dto);
        ApiResponse<Employee> response = new ApiResponse<>(
                "SUCCESS",
                "Thêm mới nhân viên thành công",
                savedEmployee
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}