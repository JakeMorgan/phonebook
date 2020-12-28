package com.example.phonebook.be.Entity;

import com.example.phonebook.be.Enums.Param;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Contact", schema = "public")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
    @Enumerated(EnumType.STRING)
    private Param param;
    private String value;
}
