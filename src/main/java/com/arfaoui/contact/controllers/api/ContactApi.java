package com.arfaoui.contact.controllers.api;

import com.arfaoui.contact.dto.ContactDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static com.arfaoui.contact.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/contacts")
public interface ContactApi {

    @PostMapping(value = APP_ROOT + "/contacts/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create contact", notes = "Creates a new contact ", response = ContactDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created Contact.")
    })
    ResponseEntity<ContactDto> createContact(
            @ApiParam(value = "Contact DTO", required = true) @RequestBody ContactDto contactDto);

    @PatchMapping(value = APP_ROOT + "/contacts/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Contact", notes = "Updates an existing Contact ", response = ContactDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created user.")
    })
    ResponseEntity<ContactDto> updateContact(
            @ApiParam(value = "Contact DTO", required = true) @RequestBody ContactDto user);

    @GetMapping(value = APP_ROOT + "/contacts/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Contact Details", notes = "Returns the list of the contacts", responseContainer = "List<ContactDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the contacts"),
    })
    ResponseEntity<List<ContactDto>> getAllContacts();

    @GetMapping(value = APP_ROOT + "/contacts/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Contact Details by user ID", notes = "Returns the list of the contacts of a selected user", responseContainer = "List<ContactDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the contacts"),
    })
    ResponseEntity<List<ContactDto>> getAllContactsByUserId(
            @ApiParam(value = "User ID", required = true) Long id
    );

    @GetMapping(value = APP_ROOT + "/contacts/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Contact Details", notes = "Returns the list of the users", response = ContactDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Contact"),
            @ApiResponse(code = 404, message = "Contact not found")
    })
    ResponseEntity<ContactDto> getContact(
            @ApiParam(value = "The contact id", required = true) @PathParam(value = "id") Long id
    );

    @DeleteMapping(value = APP_ROOT + APP_ROOT + "/contacts/delete/{id:.+}")
    @ApiOperation(value = "Delete contact", notes = "Deletes a contact by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The contact deleted"),
            @ApiResponse(code = 404, message = "Contact not found")
    })
    ResponseEntity deleteContact(
            @ApiParam(value = "The contact id", required = true) Long id
    );
}
