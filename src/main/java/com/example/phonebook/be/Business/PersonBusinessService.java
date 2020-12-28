package com.example.phonebook.be.Business;

import com.example.phonebook.be.DTO.PageDTO;
import com.example.phonebook.be.DTO.PersonDTO;
import com.example.phonebook.be.Entity.Contact;
import com.example.phonebook.be.Entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonBusinessService {
    Person createPerson(Person person);
    Person editPerson(Person personEdit);
    void deletePerson(Long id);

    PersonDTO getPerson(Long id);
    PersonDTO getPerson(Contact contact);
    Person getOnlyPerson(Long id);
    Page<Person> getPersonsList(Pageable pageable);
    PageDTO result(String filter, Pageable pageable);
    List<PersonDTO> getDuplicates();
    PersonDTO convert(Person person);
}
