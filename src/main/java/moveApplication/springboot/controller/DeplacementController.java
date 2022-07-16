package moveApplication.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import moveApplication.springboot.exception.ResourceNotFoundException;
import moveApplication.springboot.model.Deplacement;
import moveApplication.springboot.repository.DeplacementRepository;





@RestController
@RequestMapping("/deplacement")
public class DeplacementController {
	
	@Autowired
	private DeplacementRepository deplacementRepository;
	

	//get 
	
	@GetMapping()
	public List<Deplacement> getAllEmployee(){
		return this.deplacementRepository.findAll();
	}
	

	//get employee by id 
	@GetMapping("/{id}")
	public ResponseEntity<Deplacement> getDeplacementByid(@PathVariable(value = "id") Long employeeId)
	throws ResourceNotFoundException {
		Deplacement employee = deplacementRepository.findById(employeeId).orElse(null);
		new ResourceNotFoundException("Employee not found with id :: " + employeeId);
				return ResponseEntity.ok().body(employee);
	}

	//save 
	@PostMapping()
	public Deplacement createDeplacement(@RequestBody Deplacement deplacement) {
		return this.deplacementRepository.save(deplacement);
		
	}
	//update 
	@PutMapping("/{id}")
	public ResponseEntity<Deplacement> updateDeplacement(@PathVariable(value ="id") Long deplacementId,
			@Validated @RequestBody Deplacement DeplacementDetails){
		Deplacement deplacement= deplacementRepository.findById(deplacementId).orElse(null);
		new ResourceNotFoundException("Deplacement not found with id :: " + deplacementId);
		
		deplacement.setStartingPoint(DeplacementDetails.getStartingPoint());
		deplacement.setArrivalPoint(DeplacementDetails.getArrivalPoint());
		deplacement.setStatuts(DeplacementDetails.getStatuts());
		deplacement.setMeansOfTransport(DeplacementDetails.getMeansOfTransport());
		
		return ResponseEntity.ok(this.deplacementRepository.save(deplacement));
		
	}
	//delete 
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteDeplacement(@PathVariable(value ="id") Long deplacementId){
		Deplacement deplacement = deplacementRepository.findById(deplacementId).orElse(null);
		new ResourceNotFoundException("Deplacement not found with id :: " + deplacementId);
		
		this.deplacementRepository.delete(deplacement);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
	
}
	
	

