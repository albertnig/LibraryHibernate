package ru.albert.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.albert.springcourse.models.Person;
import ru.albert.springcourse.services.PeopleService;

@Component
public class PersonValidator implements Validator{
	private final PeopleService peopleService;
	
	@Autowired
	public PersonValidator (PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Person.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		if (peopleService.getPersonByFullName(person.getFullName()).isPresent())
			errors.rejectValue("fullName", "", "Это имя уже есть в базе");
	}
}
