package com.arfaoui.contact.repositories;

import com.arfaoui.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findContactByUserId(Long userId);
}
