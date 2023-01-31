package com.arfaoui.contact.dto;

import com.arfaoui.contact.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    @JsonIgnore
    private List<ContactDto> contactDtos;

    public static User toEntity(UserDto userDto) {
        final User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setContact(
                userDto.getContactDtos() != null ? userDto.getContactDtos().stream().map(ContactDto::toEntity).collect(Collectors.toList()) : null
        );

        return user;
    }

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .password(user.getPassword())
                .email(user.getEmail())
                .contactDtos(
                        user.getContact() != null ? user.getContact().stream().map(ContactDto::fromEntity).collect(Collectors.toList()) : null
                )
                .build();
    }
}
