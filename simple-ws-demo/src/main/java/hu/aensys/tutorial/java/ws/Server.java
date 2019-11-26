package hu.aensys.tutorial.java.ws;

import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/BookService", new BookService());
    }

}
