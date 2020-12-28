package com.example.phonebook.be.Business;

import com.example.phonebook.be.Access.PersonRepository;
import com.example.phonebook.be.DTO.*;
import com.example.phonebook.be.Entity.Contact;
import com.example.phonebook.be.Entity.Person;
import com.example.phonebook.be.Exceptions.NotFoundException;
import com.example.phonebook.be.Mappers.ContactNPMapper;
import com.example.phonebook.be.Mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonBusinessServiceImpl implements PersonBusinessService{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ContactBusinessService contactBusinessService;
    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person editPerson(Person personEdit) {
        Person person = personRepository.findById(personEdit.getId()).orElseThrow(NotFoundException::new);
        person.setFcs(personEdit.getFcs());
        person.setDob(personEdit.getDob());
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO getPerson(Long id) {
        return convert(personRepository.findById(id).orElseThrow(NotFoundException::new));
    }
    public Person getOnlyPerson(Long id){
        return personRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    @Override
    public PersonDTO getPerson(Contact contact){
        return getPerson(contactBusinessService.getContact(contact).getPerson().getId());
    }
    public Page<Person> getPersonsListByFilter(String filter, Pageable pageable){
        return personRepository.findByFcsContainingIgnoreCase(filter, pageable);
    }
    @Override
    public Page<Person> getPersonsList(Pageable pageable){
        return personRepository.findAll(pageable);
    }
    @Override
    public PageDTO result(String filter, Pageable pageable){
        if(filter != null && !filter.isEmpty()){
            return convertList(getPersonsListByFilter(filter, pageable));
        }else{
            return convertList(getPersonsList(pageable));
        }
    }
    @Override
    public List<PersonDTO> getDuplicates() {
        List<Long> listId = personRepository.getPersonDuplicates();
        List<PersonDTO> personDTOList = new LinkedList<>();
        for(Long id:listId){
            personDTOList.add(convert(personRepository.findById(id).get()));
        }
        return personDTOList;
    }

    public PageDTO convertList(Page<Person> personList){
        Page<PersonDTO> personDTOPage = personList.map(this::convert);
        return new PageDTO(personDTOPage.getContent(),
                new PageableDTO(personDTOPage.getTotalPages(),
                        personDTOPage.getTotalElements(), personDTOPage.getNumber()));
    }

    public PersonDTO convert(Person person){
        PersonDTO personDTO = PersonMapper.INSTANCE.toDTO(person);
        List<ContactNPDTO> contactNPDTOList = ContactNPMapper.INSTANCE.toContactNPDTOList(person.getContacts());
        personDTO.setContactsList(contactNPDTOList);
        return personDTO;
    }
}
