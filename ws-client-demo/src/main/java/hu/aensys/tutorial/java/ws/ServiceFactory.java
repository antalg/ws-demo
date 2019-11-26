package hu.aensys.tutorial.java.ws;

import javax.xml.namespace.QName;

public class ServiceFactory {

    private static final QName SERVICE_NAME = new QName("http://www.cleverbuilder.com/BookService/", "BookService");

    public static BookService getBookService() {
        return new BookService_Service(BookService_Service.WSDL_LOCATION, SERVICE_NAME).getBookServiceSOAP();
    }

}
