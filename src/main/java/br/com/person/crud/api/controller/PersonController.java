package br.com.person.crud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.person.crud.api.model.Person;
import br.com.person.crud.api.service.PersonService;
import br.com.person.crud.api.utils.CustomPage;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("")
	public CustomPage<Person> find(
			@RequestParam(value = "$pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "$pageSize", required = false) Integer pageSize,
			@RequestParam(value = "$filter", required = false) String filter) {
		return personService.find(pageNumber, pageSize, filter);
	}
	
	@GetMapping("/{id}")
	public CustomPage<Person> findById(
			@PathVariable("id") Integer id,
			@RequestParam(value = "$pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "$pageSize", required = false) Integer pageSize) {
		return this.personService.findById(id, pageNumber, pageSize);
	}
	
	@PostMapping(path = "/new", consumes = "application/json")
	public Person save(@RequestBody Person person) {
		return this.personService.save(person);
	}
	
	@PutMapping(path = "/{id}/update") 
	public Person update(@RequestBody Person person, @PathVariable("id") Integer id) {
		return this.personService.update(person, id);
	}
	
	@DeleteMapping(path = "/{id}/remove")
	public void removeById(@PathVariable("id") Integer id) {
		this.personService.remove(id); 
	}
}
