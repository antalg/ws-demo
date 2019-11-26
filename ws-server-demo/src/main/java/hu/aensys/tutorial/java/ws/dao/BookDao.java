package hu.aensys.tutorial.java.ws.dao;

import hu.aensys.tutorial.java.ws.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookDao {

    private Long lastId = 1L;

    private List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public Book findById(Long id) {
        return books.stream()
                .filter(book -> Objects.equals(id, book.getId()))
                .findFirst()
                .orElse(null);
    }

    public void save(Book book) {
        book.setId(lastId++);
        books.add(book);
    }

}
