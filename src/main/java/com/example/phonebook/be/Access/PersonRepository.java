package com.example.phonebook.be.Access;

import com.example.phonebook.be.Entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, OtherEM{
    Optional<Person> findById(Long id);
    Page<Person> findAll(Pageable pageable);
    Page<Person> findByFcsContainingIgnoreCase(String fcs, Pageable pageable);
}
