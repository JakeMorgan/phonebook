package com.example.phonebook.be.Access;

import com.example.phonebook.be.DTO.PersonDTO;
import com.example.phonebook.be.Entity.Contact;
import com.example.phonebook.be.Entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OtherEM{
    List<Long> getPersonDuplicates();
    List<Long> getContactDuplicates();
}
