package hu.aensys.tutorial.java.ws;

import hu.aensys.tutorial.java.ws.service.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.xml.ws.Endpoint;

@Slf4j
public class Server {

    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        Endpoint.publish("http://localhost:8080/BookService", bookService);
        log.info("BookService started");
    }

}
