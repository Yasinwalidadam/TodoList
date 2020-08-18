package com.backend.Autoforamtion.Resource;

import java.net.URI;


import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.Autoformation.entities.AutoJpaRepository;
import com.backend.Autoformation.entities.todo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AutoformationResource {

	@Autowired
	private AutoJpaRepository jpaRepository;

	
	@GetMapping(path = "/users/{username}/projects")
	public List<todo> getAllProjects(@PathVariable String username) {
		return jpaRepository.findByUsername(username);
		
	}
	
	@GetMapping(path = "/users/{username}/projects/{id}")
	public todo getProject(@PathVariable long id) {
		
		return jpaRepository.findById(id).get();
	}
	
	@PostMapping("/users/{username}/projects")
	public ResponseEntity<Void> AddProject(@PathVariable String username,@RequestBody todo todo)
	{
		todo CreatProject=jpaRepository.save(todo);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(CreatProject.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		}
	
	
	@DeleteMapping("/users/{username}/projects/{id}")
	public ResponseEntity<Void> deletProject(@PathVariable String username,@PathVariable long id)
	{
		jpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/users/{username}/projects/{id}")
	public ResponseEntity<todo> updateProjectFormation(@PathVariable String username,@PathVariable long id,@RequestBody todo todo)
	{
		todo ProjectUpdate=jpaRepository.save(todo);
		return new ResponseEntity<todo>(todo,HttpStatus.OK);
		
	}
	
	


}
