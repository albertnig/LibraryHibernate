package ru.albert.springcourse.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Book")
public class Book {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Название книги не должно быть пустым")
	@Size (min=2, max=200, message = "Название книги должно содержать от 2 до 200 символов")
	@Column(name="title")
	private String title;
	
	@NotEmpty(message = "Имя автора не должно быть пустым")
	@Size (min=2, max=100, message = "Имя автора должно содержать от 2 до 100 символов")
	@Column(name="author")
	private String author;
	
	@Min (value = 1901, message = "Год издания книги должен быть больше чем 1900")
	@Column(name="year")
	private int year;
	
	@ManyToOne
	@JoinColumn(name="person_id", referencedColumnName = "id")
	private Person owner;
	
	@Column(name="taken_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date takenAt;
	
	@Transient
    private boolean expired; // Hibernate не будет замечать этого поля, что нам и нужно. По-умолчанию false.
	
	public Book() {
	
	}
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public Date getTakenAt() {
		return takenAt;
	}
	public void setTakenAt(Date takenAt) {
		this.takenAt = takenAt;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
}
