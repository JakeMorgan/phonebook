package com.example.phonebook.be.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageableDTO {
    private Integer totalPages;
    private Long totalElements;
    private Integer number;
}
