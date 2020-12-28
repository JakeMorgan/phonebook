package com.example.phonebook.be.Business;

import com.example.phonebook.be.DTO.ContactDTO;
import com.example.phonebook.be.DTO.PageDTO;
import com.example.phonebook.be.Entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactBusinessService {
    ContactDTO createContact(Contact contact);
    ContactDTO editContact(Contact contactEdit);
    void deleteContact(Long id);

    ContactDTO getContact(Long id);
    ContactDTO getContact(Contact contact);
    PageDTO result(String filter, Pageable pageable);
    List<ContactDTO> getDuplicates();
}
