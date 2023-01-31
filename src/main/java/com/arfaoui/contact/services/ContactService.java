package com.arfaoui.contact.services;

import com.arfaoui.contact.dto.ContactDto;

import java.util.List;

public interface ContactService {

    ContactDto save(ContactDto contact);

    List<ContactDto> findAll();

    ContactDto findById(Long id);

    List<ContactDto> findAllByUserId(Long userId);

    void delete(Long id);

}
