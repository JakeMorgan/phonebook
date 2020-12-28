package com.example.phonebook.be.Business;

import com.example.phonebook.be.Access.ContactsRepository;
import com.example.phonebook.be.DTO.ContactDTO;
import com.example.phonebook.be.DTO.PageDTO;
import com.example.phonebook.be.DTO.PageableDTO;
import com.example.phonebook.be.Entity.Contact;
import com.example.phonebook.be.Exceptions.NotFoundException;
import com.example.phonebook.be.Mappers.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ContactBusinessServiceImpl implements ContactBusinessService {
    @Autowired
    private ContactsRepository contactsRepository;
    @Autowired
    private PersonBusinessService personBusinessService;

    @Override
    public ContactDTO createContact(Contact contact) {
        contact.setPerson(personBusinessService.getOnlyPerson(contact.getPerson().getId()));
        return convert(contactsRepository.save(contact));
    }

    @Override
    public ContactDTO editContact(Contact contactEdit) {
        Contact contact = contactsRepository.findById(contactEdit.getId()).orElseThrow(NotFoundException::new);
        contact.setPerson(personBusinessService.getOnlyPerson(contactEdit.getPerson().getId()));
        contact.setParam(contactEdit.getParam());
        contact.setValue(contactEdit.getValue());
        return convert(contactsRepository.save(contact));
    }

    @Override
    public void deleteContact(Long id) {
        contactsRepository.deleteById(id);
    }

    @Override
    public ContactDTO getContact(Long id) {
        return convert(contactsRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public ContactDTO getContact(Contact contact){
        return convert(contactsRepository.findByParamAndValue(contact.getParam(), contact.getValue()).orElseThrow(NotFoundException::new));
    }

    public List<ContactDTO> getDuplicates(){
        List<Long> listId = contactsRepository.getContactDuplicates();
        List<ContactDTO> contactDTOList = new LinkedList<>();
        for(Long id:listId){
            contactDTOList.add(convert(contactsRepository.findById(id).get()));
        }
        return contactDTOList;
    }

    @Override
    public PageDTO result(String filter, Pageable pageable){
        if(filter != null && !filter.isEmpty()){
            return convertList(getContactsListByFilter(filter, pageable));
        }else{
            return convertList(getContactsList(pageable));
        }
    }

    public Page<Contact> getContactsListByFilter(String filter, Pageable pageable){
        return contactsRepository.findByParamContainingIgnoreCase(filter, pageable);
    }

    public Page<Contact> getContactsList(Pageable pageable){
        return contactsRepository.findAll(pageable);
    }


    public PageDTO convertList(Page<Contact> contactsList){
        Page<ContactDTO> contactDTOPage = contactsList.map(this::convert);
        return new PageDTO(contactDTOPage.getContent(),
                new PageableDTO(contactDTOPage.getTotalPages(),
                        contactDTOPage.getTotalElements(), contactDTOPage.getNumber()));
    }

    public ContactDTO convert(Contact contact){
        return ContactMapper.INSTANCE.toDTO(contact);
    }

}
