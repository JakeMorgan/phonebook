package com.example.phonebook.be.Mappers;

import com.example.phonebook.be.DTO.PersonDTO;
import com.example.phonebook.be.Entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDTO toDTO(Person person);
}
