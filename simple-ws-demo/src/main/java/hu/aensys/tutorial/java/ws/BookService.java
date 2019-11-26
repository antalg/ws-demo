package hu.aensys.tutorial.java.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebService
public class BookService {

    private List<Book> books = new ArrayList<>();

    @WebMethod
    public List<Book> getBooks() {
        return books;
    }

    @WebMethod
    public void addBook(Book book) {
        books.add(book);
    }

}
