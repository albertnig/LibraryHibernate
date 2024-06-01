package ru.albert.springcourse.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import ru.albert.springcourse.models.Book;
//import ru.albert.springcourse.models.Person;
//import java.util.List;
//import java.util.Optional;
//
@Component
public class BookDAO {
//
//	private final SessionFactory sessionFactory;
//	
//	@Autowired
//	public BookDAO(SessionFactory sessionFactory) {
//		this.sessionFactory= sessionFactory;
//		}
//
//	@Transactional (readOnly = true)
//	public List<Book> index() {
//		Session session = sessionFactory.getCurrentSession();
//		return session.createQuery("select p from Book p", Book.class).getResultList();
//}
//	@Transactional (readOnly = true)
//	public Book show(int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.get(Book.class, id);
//}
//	@Transactional
//	public void save (Book book) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(book);
//}
//	@Transactional
//	public void update (int id, Book updatedBook) {
//		Session session = sessionFactory.getCurrentSession();
//		Book bookToBeUpdated = session.get(Book.class, id);
//		
//		bookToBeUpdated.setTitle(updatedBook.getTitle());
//		bookToBeUpdated.setAuthor(updatedBook.getAuthor());
//		bookToBeUpdated.setYear(updatedBook.getYear());
//}
//	@Transactional
//	public void delete (int id) {
//		Session session = sessionFactory.getCurrentSession();
//		session.remove(session.get(Book.class, id));
//}
//	//Назначаем книгу человеку
//	@Transactional
//	public void assign (int id, Person selectedPerson) {
//		Session session = sessionFactory.getCurrentSession();
//		Book book = session.get(Book.class, id);
//		book.setOwner(selectedPerson);
//		selectedPerson.getBooks().add(book);
//}
////Освобождаем книгу
//	@Transactional
//	public void liberate (int id, Person person) {
//		Session session = sessionFactory.getCurrentSession();
//		Book book = session.get(Book.class, id);
//		book.setOwner(null);
//		person.getBooks().remove(book);
//}
////Смотрим кому принадлежит
//	@Transactional
//	public Optional<Person> occupyRelease (int id) {
//		Session session = sessionFactory.getCurrentSession();
//		return Optional.ofNullable(session.get(Book.class, id).getOwner());
//}
}
