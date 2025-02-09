package ru.albert.springcourse.repositories; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.albert.springcourse.models.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
	List<Book> findByTitleStartingWith(String title);
}
