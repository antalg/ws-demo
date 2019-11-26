package hu.aensys.tutorial.java.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    public static void main(String[] args) throws JAXBException {
        Department department = new Department(101L, "IT");
        Employee employee = new Employee(1L, "John", "Smith", department);

        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(employee, System.out);
    }

}
