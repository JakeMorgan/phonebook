package com.example.phonebook.be.Controllers;

import com.example.phonebook.be.Business.PersonBusinessService;
import com.example.phonebook.be.DTO.PageDTO;
import com.example.phonebook.be.DTO.PersonDTO;
import com.example.phonebook.be.Entity.Contact;
import com.example.phonebook.be.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonBusinessService personBusinessService;

    @GetMapping()
    public PageDTO personsList(
            @RequestParam(required = false, defaultValue = "") String filter,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ){
        return personBusinessService.result(filter, pageable);
    }
    @GetMapping("/duplicates")
    public List<PersonDTO> getDuplicates(){
        return personBusinessService.getDuplicates();
    }
    @PostMapping("/search")
    public PersonDTO getPersonSearch(@RequestBody Contact contact){
        return personBusinessService.getPerson(contact);
    }
    @GetMapping("{id}")
    public PersonDTO getPerson(@PathVariable Long id){
        return personBusinessService.getPerson(id);
    }

    @PostMapping()
    public Person createPerson(@RequestBody Person person){
        return personBusinessService.createPerson(person);
    }
    @PutMapping()
    public Person editPerson(@RequestBody Person person){
        return personBusinessService.editPerson(person);
    }
    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable Long id){
        personBusinessService.deletePerson(id);
    }
}
