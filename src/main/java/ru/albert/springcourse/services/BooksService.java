package ru.albert.springcourse.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.albert.springcourse.models.Book;
import ru.albert.springcourse.models.Person;
import ru.albert.springcourse.repositories.BooksRepository;


@Service
@Transactional(readOnly = true)
public class BooksService {
	private final BooksRepository booksRepository;

	@Autowired
	public BooksService(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}
	
	public List<Book> findAll(boolean sortByYear){
		if (sortByYear)
			return booksRepository.findAll(Sort.by("year"));
		else
			return booksRepository.findAll();
	}
	
	public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear) {
		if (sortByYear)
			return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
		else
			return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
	}
	
	public Book findOne (int id) {
		Optional<Book> foundBook = booksRepository.findById(id);
		return foundBook.orElse(null);
	}
	
	public List<Book> searchByTitle(String query){
		return booksRepository.findByTitleStartingWith(query);
	}
	
	@Transactional
	public void save(Book book) {
		booksRepository.save(book);
	}
	
	@Transactional
	public void update(int id, Book updatedBook) {
		
		 Book bookToBeUpdated = booksRepository.findById(id).get();
	     // (Наиль добавил эту строку) добавляем по сути новую книгу (которая не находится в Persistence context), поэтому нужен save()
		
		updatedBook.setId(id);
		
		updatedBook.setOwner(bookToBeUpdated.getOwner()); // (Наиль добавил эту строку) чтобы не терялась связь при обновлении
		
		booksRepository.save(updatedBook);
	}
	
	@Transactional
	public void delete(int id) {
		booksRepository.deleteById(id);
	}
	
	//Кому принадлежит книга:
	// Returns null if book has no owner
	public Person getBookOwner (int id) {
		// Здесь Hibernate.initialize() не нужен, так как владелец (сторона One) загружается не лениво
		 return booksRepository.findById(id).map(Book::getOwner).orElse(null);
		}
	
	//Освобождает книгу:
	@Transactional
	public void release(int id) {
		booksRepository.findById(id).ifPresent(
		book -> {
		book.setOwner(null);
		book.setTakenAt(null); //обнуляем время выдачи книги
		});
	}
	
	//Назначает книгу:
	@Transactional
	public void assign (int id, Person selectedPerson) {
		booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(selectedPerson);
                    book.setTakenAt(new Date()); // текущее время
                }
        );
	}
}
