package com.example.phonebook.be.Access;

import com.example.phonebook.be.Business.PersonBusinessService;
import com.example.phonebook.be.DTO.PersonDTO;
import com.example.phonebook.be.Entity.Contact;
import com.example.phonebook.be.Entity.Person;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class OtherEMImpl implements OtherEM{
    @PersistenceContext
    private EntityManager entityManager;
    private PersonBusinessService personBusinessService;
    public List<Long> getPersonDuplicates(){
        try {
            //TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p WHERE (SELECT COUNT(*) FROM Person pe WHERE pe.fcs = p.fcs AND pe.dob = p.dob) > 1", Person.class);
            Query query = entityManager.createNativeQuery("SELECT id FROM public.person p WHERE (SELECT COUNT(*) FROM public.person pe WHERE p.dob = pe.dob AND p.fcs = pe.fcs) > 1;");
            return query.getResultList();
        }catch (NoResultException ex){
            return null;
        }
    }
    public List<Long> getContactDuplicates(){
        try{
            Query query = entityManager.createNativeQuery("SELECT id FROM public.contact c WHERE (SELECT COUNT(*) FROM public.contact co WHERE c.param = co.param AND c.value = co.value) > 1;");
            return query.getResultList();
        }catch (NoResultException ex){
            return null;
        }
    }
}
