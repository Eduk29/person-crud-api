package br.com.person.crud.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.person.crud.api.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	Page<Person> findAll(Pageable pageable);
	Page<Person> findByNameLike(String name, Pageable pageable);
	Page<Person> findByGenderLike(String gender, Pageable pageable);
	Page<Person> findByHomeworldLike(String homeworld, Pageable pageable);
	Page<Person> findBySpeciesLike(String species, Pageable pageable);
	Page<Person> findById(Integer id, Pageable pageable);
	<S extends Person> S save(Person person);
}
