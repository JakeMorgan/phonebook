package com.example.phonebook.be.Controllers;

import com.example.phonebook.be.Business.ContactBusinessService;
import com.example.phonebook.be.DTO.ContactDTO;
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
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactBusinessService contactBusinessService;

    @GetMapping()
    public PageDTO contactsList(
            @RequestParam(required = false, defaultValue = "") String filter,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ){
        return contactBusinessService.result(filter, pageable);
    }
    @GetMapping("{id}")
    public ContactDTO getContact(@PathVariable Long id){
        return contactBusinessService.getContact(id);
    }
    @GetMapping("/duplicates")
    public List<ContactDTO> getDuplicates(){
        return contactBusinessService.getDuplicates();
    }
    @PostMapping()
    public ContactDTO createContact(@RequestBody Contact contact){
        return contactBusinessService.createContact(contact);
    }
    @PutMapping()
    public ContactDTO editContact(@RequestBody Contact contact){
        return contactBusinessService.editContact(contact);
    }
    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable Long id){
        contactBusinessService.deleteContact(id);
    }
}
