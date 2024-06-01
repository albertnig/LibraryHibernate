package ru.albert.springcourse.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import ru.albert.springcourse.models.Book;
//import ru.albert.springcourse.models.Person;
//
//import java.util.List;
//import java.util.Optional;
//
@Component
public class PersonDAO {
//	
//	private final SessionFactory sessionFactory;
//	
//	@Autowired
//public PersonDAO(SessionFactory sessionFactory) {
//		this.sessionFactory= sessionFactory;
//	}
//
//	@Transactional (readOnly = true)
//	public List<Person> index() {
//		Session session = sessionFactory.getCurrentSession();
//		return session.createQuery("select p from Person p", Person.class).getResultList();
//}
//
//	@Transactional(readOnly = true)
//	public Optional<Person> show(String fullName) {
//		Session session = sessionFactory.getCurrentSession();
//		return Optional.ofNullable(session.get(Person.class, fullName));
//}
//	@Transactional(readOnly = true)
//	public Person show(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.get(Person.class, id);
//}
//	@Transactional
//	public void save (Person person) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(person);
//}
//	@Transactional
//	public void update (int id, Person updatedPerson) {
//		Session session = sessionFactory.getCurrentSession();
//		Person personToBeUpdated = session.get(Person.class, id);
//		
//		personToBeUpdated.setFullName(updatedPerson.getFullName()); 
//		personToBeUpdated.setYearOfBirth(updatedPerson.getYearOfBirth());
//}
//	@Transactional
//	public void delete (int id) {
//		Session session = sessionFactory.getCurrentSession();
//		session.remove(session.get(Person.class, id));
//}
//	@Transactional
//	public List<Book> employ (int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.get(Person.class, id).getBooks();
//}
}
