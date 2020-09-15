package br.com.person.crud.api.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.person.crud.api.model.Person;
import br.com.person.crud.api.repository.PersonRepository;
import br.com.person.crud.api.utils.CustomPage;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public CustomPage<Person> findAll(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Person> page = personRepository.findAll(pageable);
		
		CustomPage customPage = new CustomPage<Person>(page);
		
		return customPage;
	}	
}

