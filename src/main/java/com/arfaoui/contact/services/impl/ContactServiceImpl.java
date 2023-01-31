package com.arfaoui.contact.services.impl;

import com.arfaoui.contact.dto.ContactDto;
import com.arfaoui.contact.exception.EntityNotFoundException;
import com.arfaoui.contact.exception.ErrorCodes;
import com.arfaoui.contact.exception.InvalidEntityException;
import com.arfaoui.contact.repositories.ContactRepository;
import com.arfaoui.contact.services.ContactService;
import com.arfaoui.contact.validators.ContactValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactDto save(ContactDto contact) {
        List<String> errors = ContactValidator.validateContact(contact);
        if (!errors.isEmpty()) {
            log.error("Contact is not valid {}", contact);
            throw new InvalidEntityException("Contact is not valid", ErrorCodes.CONTACT_IS_NOT_VALID, errors);
        }
        return ContactDto.fromEntity(contactRepository.save(ContactDto.toEntity(contact)));
    }

    @Override
    public List<ContactDto> findAll() {
        return contactRepository.findAll().stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Long id) {
        if (id == null) {
            log.error("Contact id is null");
            return null;
        }
        return contactRepository.findById(id).map(ContactDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Contact found with ID = " + id, ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<ContactDto> findAllByUserId(Long userId) {
        return contactRepository.findContactByUserId(userId).stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Contact id is null");
            return;
        }
        contactRepository.deleteById(id);
    }

}
