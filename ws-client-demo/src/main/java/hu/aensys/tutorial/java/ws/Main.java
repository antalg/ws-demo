package hu.aensys.tutorial.java.ws;

import lombok.extern.slf4j.Slf4j;

import javax.xml.ws.Holder;
import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        BookService bookService = ServiceFactory.getBookService();

        bookService.addBook("1984", "George Orwell");
        bookService.addBook("Ender's Game", "Orson Scott Card");
        String lastBookId = bookService.addBook("Ready Player One", "Ernest Cline");

        List<GetAllBooksResponse.Book> books = bookService.getAllBooks();
        books.forEach(
                book -> log.info("ID: {}, author: {}, title: {}", book.getID(), book.getAuthor(), book.getTitle())
        );

        Holder<String> lastBookAuthor = new Holder<>();
        Holder<String> lastBookTitle = new Holder<>();
        bookService.getBook(new Holder<>(lastBookId), lastBookTitle, lastBookAuthor);

        log.info("Last book - author: {}, title: {}", lastBookAuthor.value, lastBookTitle.value);
    }

}
