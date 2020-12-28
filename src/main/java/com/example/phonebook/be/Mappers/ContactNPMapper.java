package com.example.phonebook.be.Mappers;

import com.example.phonebook.be.DTO.ContactDTO;
import com.example.phonebook.be.DTO.ContactNPDTO;
import com.example.phonebook.be.Entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactNPMapper {
    ContactNPMapper INSTANCE = Mappers.getMapper(ContactNPMapper.class);
    ContactNPDTO toDTO(Contact contact);
    List<ContactNPDTO> toContactNPDTOList(List<Contact> list);
}
