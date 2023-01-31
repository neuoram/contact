package com.arfaoui.contact.controllers.api;

import com.arfaoui.contact.utils.Constants;
import com.arfaoui.contact.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("authApi")
public interface AuthApi {

    @ApiOperation(value = "Login user", notes = "Creates a new user ", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The connected user.")
    })
    @PostMapping(value = Constants.APP_ROOT + "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> loginUser(
            @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user
    );
}
