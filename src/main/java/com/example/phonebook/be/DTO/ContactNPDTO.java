package com.example.phonebook.be.DTO;

import com.example.phonebook.be.Enums.Param;
import lombok.Data;

@Data
public class ContactNPDTO {
    private Long id;
    private Param param;
    private String value;
}
