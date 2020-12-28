package com.example.phonebook.be.Mappers;

import com.example.phonebook.be.DTO.PersonNCDTO;
import com.example.phonebook.be.Entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonNCMapper {
    PersonNCMapper INSTANCE = Mappers.getMapper(PersonNCMapper.class);
    PersonNCDTO toDTO(Person person);
}
