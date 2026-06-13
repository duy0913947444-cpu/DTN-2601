package com.vti.Controller;

import com.vti.Entity.Department;
import com.vti.Service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findByID(@PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(departmentService.findByID(id), HttpStatus.OK);
    }
    @GetMapping(value = "/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name){
        return new ResponseEntity<>(departmentService.findByName(name), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDepartment(@RequestBody Department department,
                                              @PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(departmentService.updateDepartment(department, id), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") Integer id){
        departmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
