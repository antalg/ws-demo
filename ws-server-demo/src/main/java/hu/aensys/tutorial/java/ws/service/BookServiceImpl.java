package hu.aensys.tutorial.java.ws.service;

import hu.aensys.tutorial.java.ws.BookService;
import hu.aensys.tutorial.java.ws.GetAllBooksResponse;
import hu.aensys.tutorial.java.ws.dao.BookDao;
import hu.aensys.tutorial.java.ws.model.Book;

import javax.xml.ws.Holder;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDao();

    @Override
    public void getBook(Holder<String> id, Holder<String> title, Holder<String> author) {
        Book book = bookDao.findById(Long.parseLong(id.value));

        if (book == null) {
            throw new IllegalArgumentException("User not found with ID: " + id.value);
        }

        author.value = book.getAuthor();
        title.value = book.getTitle();
    }

    @Override
    public String addBook(String title, String author) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);

        bookDao.save(book);
        return book.getId().toString();
    }

    @Override
    public List<GetAllBooksResponse.Book> getAllBooks() {
        List<Book> books = bookDao.findAll();
        return books.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private GetAllBooksResponse.Book convert(Book book) {
        GetAllBooksResponse.Book bookResult = new GetAllBooksResponse.Book();
        bookResult.setID(book.getId().toString());
        bookResult.setAuthor(book.getAuthor());
        bookResult.setTitle(book.getTitle());
        return bookResult;
    }

}
