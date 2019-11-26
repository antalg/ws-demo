package hu.aensys.tutorial.java.jaxb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private Department department;

}
