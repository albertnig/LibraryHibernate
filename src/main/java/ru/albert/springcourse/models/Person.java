package ru.albert.springcourse.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Person")
public class Person{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Имя не должно быть пустым")
	@Size (min=2, max=100, message = "ФИО должно содержать от 2 до 100 символов")
	@Column(name="full_name")
	private String fullName;
	
	@Min (value = 1901, message = "Год рождения должен быть больше чем 1900")
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
	@OneToMany(mappedBy="owner")
	private List<Book> books;
	
	public Person() {
		
	}
	public Person(String fullName, int yearOfBirth) {
		this.fullName = fullName;
		this.yearOfBirth=yearOfBirth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
