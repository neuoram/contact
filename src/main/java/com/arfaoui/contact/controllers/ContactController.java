package com.arfaoui.contact.controllers;

import com.arfaoui.contact.controllers.api.ContactApi;
import com.arfaoui.contact.dto.ContactDto;
import com.arfaoui.contact.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactController implements ContactApi {

    @Autowired
    private ContactService contactService;

    @Override
    public ResponseEntity<ContactDto> createContact(ContactDto contactDto) {
        return new ResponseEntity<>(contactService.save(contactDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ContactDto> updateContact(ContactDto contactDto) {
        return new ResponseEntity<>(contactService.save(contactDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ContactDto>> getAllContactsByUserId(Long id) {
        return new ResponseEntity<>(contactService.findAllByUserId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContactDto> getContact(Long id) {
        return new ResponseEntity<>(contactService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteContact(Long id) {
        contactService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
