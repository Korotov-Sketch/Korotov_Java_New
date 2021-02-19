package com.project.things.controllers;

import com.project.things.entities.Employee;
import com.project.things.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestParam(required = false, defaultValue = "fname") String fname,
                                @RequestParam(required = false, defaultValue = "position") String position,
                                @RequestParam(required = false, defaultValue = "salary") Integer salary,
                                @RequestParam(required = false, defaultValue = "sname") String sname,
                                @RequestParam(required = true, value = "station_id") Integer station_id){
        return employeeService.createEmployee(fname, sname, position, salary, station_id);
    }
    @GetMapping(value = "/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PatchMapping(value = "/updateEmployee")
    public Employee updateEmployeeById(@RequestParam Integer id, @RequestParam String newFname,
                                       @RequestParam String newPosition, @RequestParam Integer newSalary,
                                       @RequestParam String newSname, @RequestParam Integer newStationId){
        return employeeService.updateEmployee(id, newFname, newPosition,
                newSalary, newSname, newStationId);
    }
    @DeleteMapping(value = "/deleteEmployee")
    public void deleteEmployeeById(@RequestParam Integer id){
        employeeService.deleteEmployee(id);
    }
}
