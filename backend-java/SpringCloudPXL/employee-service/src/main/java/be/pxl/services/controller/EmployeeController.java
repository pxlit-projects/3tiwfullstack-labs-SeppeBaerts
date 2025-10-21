package be.pxl.services.controller;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.domain.dto.mapper.EmployeeMapper;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAll() {

        List<EmployeeResponse> responses = employeeService.getAllEmployees().stream().map(EmployeeMapper::toResponse).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> add(@RequestBody EmployeeRequest request){
        Employee saved = employeeService.addEmployee(EmployeeMapper.toEntity(request));
        return new ResponseEntity<>(EmployeeMapper.toResponse(saved), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(EmployeeMapper.toResponse(employeeService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeResponse>> findByDepartment(@PathVariable Long departmentId){
        List<EmployeeResponse> responses = employeeService.findByDepartment(departmentId).stream().map(EmployeeMapper::toResponse).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<EmployeeResponse>> findByOrganization(@PathVariable Long organizationId){
        List<EmployeeResponse> responses = employeeService.findByOrganization(organizationId).stream().map(EmployeeMapper::toResponse).toList();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}