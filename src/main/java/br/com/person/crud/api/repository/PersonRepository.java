package br.com.person.crud.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.person.crud.api.model.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	Page<Person> findAll(Pageable pageable);
	
}
