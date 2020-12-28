package com.example.phonebook.be.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageDTO {
    private List<?> content;
    private PageableDTO pageableDTO;
}
