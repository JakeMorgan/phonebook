package com.example.phonebook.be.DTO;

import com.example.phonebook.be.Entity.Person;
import com.example.phonebook.be.Enums.Param;
import lombok.Data;

@Data
public class ContactDTO {
    private Long id;
    private PersonNCDTO person;
    private Param param;
    private String value;
}
