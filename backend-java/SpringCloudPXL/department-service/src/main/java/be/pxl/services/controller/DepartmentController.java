package be.pxl.services.controller;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.domain.dto.mapper.DepartmentMapper;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<DepartmentResponse> add(@RequestBody DepartmentRequest request) {
        Department saved = departmentService.add(DepartmentMapper.toEntity(request));
        return new ResponseEntity<>(DepartmentMapper.toResponse(saved), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(DepartmentMapper.toResponse(departmentService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(DepartmentMapper.toResponseList(departmentService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<?> findByOrganization(@PathVariable Long organizationId) {
        return new ResponseEntity<>(DepartmentMapper.toResponseList(departmentService.findByOrganization(organizationId)), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<?> findByOrganizationWithEmployees(@PathVariable Long organizationId) {
        return new ResponseEntity<>(DepartmentMapper.toResponseList(departmentService.findByOrganizationWithEmployees(organizationId)), HttpStatus.OK);
    }
}

