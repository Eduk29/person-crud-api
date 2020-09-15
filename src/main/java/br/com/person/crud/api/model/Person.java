package br.com.person.crud.api.model;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CRUD_PERSON")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	@SequenceGenerator(name = "seq_generator", sequenceName = "seq_crud_person", allocationSize = 1)
	@Column(name = "ID_PERSON", nullable = false, precision = 8, scale = 0)
	private Integer id;

	@Column(name = "NAME_PERSON", nullable = false, length = 255)
	private String name;

	@Column(name = "ACTOR_NAME_PERSON", nullable = false, length = 255)
	private String actorName;

	@Column(name = "HEIGHT_PERSON", nullable = false, precision = 8, scale = 0)
	private Integer height;

	@Column(name = "MASS_PERSON", nullable = false, precision = 8, scale = 0)
	private Integer mass;

	@Column(name = "BIRTHDAY_PERSON", nullable = false, length = 255)
	private String birthday;

	@Column(name = "GENDER_PERSON", nullable = false, length = 255)
	private String gender;

	@Column(name = "HOMEWORLD_PERSON", nullable = false, length = 255)
	private String homeworld;

	@Column(name = "SPECIES_PERSON", nullable = false, length = 255)
	private String species;

	@Column(name = "CREATED_PERSON", nullable = false, length = 255)
	private String createdDate;

	@Column(name = "EDITED_PERSON", nullable = false, length = 255)
	private String editedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getMass() {
		return mass;
	}

	public void setMass(Integer mass) {
		this.mass = mass;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(String editedDate) {
		this.editedDate = editedDate;
	}
}
