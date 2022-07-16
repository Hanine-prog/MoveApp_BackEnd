package moveApplication.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import moveApplication.springboot.exception.ResourceNotFoundException;
import moveApplication.springboot.model.Employee;
import moveApplication.springboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	 
	//get employee 
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
		return this.employeeRepository.findAll();
	}
	
	
	//get employee by id 
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeByid(@PathVariable(value = "id") Long employeeId)
	throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow();
		new ResourceNotFoundException("Employee not found with id :: " + employeeId);
				return ResponseEntity.ok().body(employee);
	}
	
	//save employee
	@PostMapping()
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
		
	}
	//update employee
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value ="id") Long employeeId,
			@Validated @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(employeeId).orElseThrow();
		new ResourceNotFoundException("Employee not found with id :: " + employeeId);
		
		employee.setEmail(employeeDetails.getEmail());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		
		return ResponseEntity.ok(this.employeeRepository.save(employee));
		
	}
	//delete employee
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value ="id") Long employeeId){
		Employee employee = employeeRepository.findById(employeeId).orElseThrow();
		new ResourceNotFoundException("Employee not found with id :: " + employeeId);
		
		this.employeeRepository.delete(employee);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
	
}
