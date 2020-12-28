package com.example.phonebook.be.Mappers;

import com.example.phonebook.be.DTO.ContactDTO;
import com.example.phonebook.be.Entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    ContactDTO toDTO(Contact contact);
    List<ContactDTO> toContactDTOList(List<Contact> list);
}
