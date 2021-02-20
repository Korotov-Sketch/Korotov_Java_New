package com.project.things.services;

import com.project.things.dao.EmployeeRepository;
import com.project.things.dao.FuelStationRepository;
import com.project.things.entities.Employee;
import com.project.things.entities.FuelStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;
    @Autowired
    FuelStationRepository fuelStationRepository;

    public Employee createEmployee(String fname, String sname, String  position, Integer salary, Integer shop_id){
        Employee employee = new Employee();
        employee.setFname(fname);
        employee.setSname(sname);
        employee.setPosition(position);
        employee.setSalary(salary);
        FuelStation fuelStation = fuelStationRepository.findById(shop_id).get();
        employee.setFuelStation(fuelStation);
        return repo.save(employee);
    }
    public Employee getEmployeeById(Integer employee_id){
        return repo.findById(employee_id).get();
    }

    public Employee getEmployeeByFnameAndSname(String fname, String sname){
        return repo.findAll().stream()
                .filter(elem -> (elem.getFname() == fname && elem.getSname() == sname))
                .findFirst().get();
    }

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee updateEmployee(Integer employee_id, String newFname, String newPosition, Integer newSalary, String newSname, Integer newStationId){
        FuelStation fuelStation = fuelStationRepository.findById(newStationId).get();
        Employee employee = repo.findById(employee_id).get();
        employee.setFname(newFname);
        employee.setPosition(newPosition);
        employee.setSalary(newSalary);
        employee.setSname(newSname);
        employee.setFuelStation(fuelStation);
        return repo.save(employee);
    }

    public void deleteEmployee(Integer employee_id){
        repo.deleteById(employee_id);
    }
}
