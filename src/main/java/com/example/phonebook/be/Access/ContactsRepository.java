package com.example.phonebook.be.Access;

import com.example.phonebook.be.Entity.Contact;
import com.example.phonebook.be.Enums.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactsRepository extends CrudRepository<Contact, Long>, OtherEM{
    Optional<Contact> findByParamAndValue(Param param, String value);
    Page<Contact> findByParamContainingIgnoreCase(String filter, Pageable pageable);
    Page<Contact> findAll(Pageable pageable);
}
