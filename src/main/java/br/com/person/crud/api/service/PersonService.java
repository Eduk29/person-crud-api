package br.com.person.crud.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.person.crud.api.model.Person;
import br.com.person.crud.api.repository.PersonRepository;
import br.com.person.crud.api.utils.CustomPage;
import br.com.person.crud.api.utils.ServiceUtils;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public CustomPage<Person> find(Integer pageNumber, Integer pageSize, String filter) {
		CustomPage<Person> personPage = null;
		String searchMode = null;
		String searchParameter = null;
		
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 10;
		}
		
		if (filter != null) {
			String searchQuery = ServiceUtils.removeDoubleQuotes(filter);
			searchParameter = ServiceUtils.getParamSearch(searchQuery);
			searchMode = ServiceUtils.getModeSearch(searchQuery);
		} else {
			return this.findAll(pageNumber, pageSize);
		}
		
		switch(searchMode) {
		case "name": 
			personPage = this.findByName(pageNumber, pageSize, searchParameter);
			break;
			
		case "gender":
			personPage = this.findByGender(pageNumber, pageSize, searchParameter);
			break;
			
		case "homeworld":
			personPage = this.findByHomeworld(pageNumber, pageSize, searchParameter);
			break;
			
		case "species":
			personPage = this.findBySpecies(pageNumber, pageSize, searchParameter);
			break;
			
			default: 
				personPage = this.findAll(pageNumber, pageSize);
		}
		
		return personPage;
	}
	
	public CustomPage<Person> findById(Integer id, Integer pageNumber, Integer pageSize) {
		
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 10;
		}
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Person> page = this.personRepository.findById(id, pageable);
		
		CustomPage<Person> customPage = new CustomPage<Person>(page);
		
		return customPage;
	}

	private CustomPage<Person> findAll(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Person> page = personRepository.findAll(pageable);
		
		CustomPage<Person> customPage = new CustomPage<Person>(page);
		
		return customPage;
	}
	
	private CustomPage<Person> findByName(Integer pageNumber, Integer pageSize, String filter) {
		String nameToFind = "%" + filter + "%";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Person> page = personRepository.findByNameLike(nameToFind, pageable);
		
		CustomPage<Person> customPage = new CustomPage<Person>(page);
		
		return customPage;
	}
	
	private CustomPage<Person> findByGender(Integer pageNumber, Integer pageSize, String filter) {
		String genderToFind = "%" + filter + "%";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Person> page = personRepository.findByGenderLike(genderToFind, pageable);
		
		CustomPage<Person> customPage = new CustomPage<Person>(page);
		
		return customPage;
	}
	
	private CustomPage<Person> findByHomeworld(Integer pageNumber, Integer pageSize, String filter) {
		String homeworldToFind = "%" + filter + "%";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Person> page = personRepository.findByHomeworldLike(homeworldToFind, pageable);
		
		CustomPage<Person> customPage = new CustomPage<Person>(page);
		
		return customPage;
	}
	
	private CustomPage<Person> findBySpecies(Integer pageNumber, Integer pageSize, String filter) {
		String speciesToFind = "%" + filter + "%";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Person> page = personRepository.findBySpeciesLike(speciesToFind, pageable);
		
		CustomPage<Person> customPage = new CustomPage<Person>(page);
		
		return customPage;
	}
}

