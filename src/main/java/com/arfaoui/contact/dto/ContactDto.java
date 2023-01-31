package com.arfaoui.contact.dto;

import com.arfaoui.contact.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDto {

    private Long id;

    private String name;

    private String description;

    private UserDto user;

    public static Contact toEntity(ContactDto contactDto) {
        Contact contact = new Contact();

        contact.setUser(UserDto.toEntity(contactDto.getUser()));
        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setDescription(contactDto.getDescription());

        return contact;
    }

    public static ContactDto fromEntity(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .name(contact.getName())
                .description(contact.getDescription())
                .build();
    }
}
