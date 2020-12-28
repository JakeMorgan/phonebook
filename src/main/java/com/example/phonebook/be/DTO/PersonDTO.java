package com.example.phonebook.be.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PersonDTO {
    private Long id;
    private String fcs;
    private Date dob;
    private List<ContactNPDTO> contactsList = new ArrayList<>();
}
