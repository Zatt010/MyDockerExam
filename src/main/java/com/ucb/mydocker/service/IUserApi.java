package com.ucb.mydocker.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ucb.mydocker.dto.ErrorResponse;
import com.ucb.mydocker.dto.UserDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IUserApi {

    @Tag(name = "Users", description = "Get list of users")
    @Operation(summary = "List of users", description = "Returns a list of users")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Successful operation",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
                }
            ),
            @ApiResponse(
                responseCode = "400", description = "Bad request",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "500", description = "Internal server error",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "503", description = "Service unavailable",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            )
        }
    )
    @GetMapping("/users")
    public String getUsers();
    
    @Tag(name = "Users", description = "Get user by id")
    @Operation(summary = "Get user by id", description = "Returns a user by id")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Successful operation",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
                }
            ),
            @ApiResponse(
                responseCode = "400", description = "Bad request",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "404", description = "User not found",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "500", description = "Internal server error",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "503", description = "Service unavailable",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            )
        }
    )
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(String id);


    @Tag(name = "Users", description = "Create user")
    @Operation(summary = "Create user", description = "Creates a new user")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "201", description = "User created",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
                }
            ),
            @ApiResponse(
                responseCode = "400", description = "Bad request",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "500", description = "Internal server error",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "503", description = "Service unavailable",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            )
        }
    )
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(UserDto user);
     @Tag(name = "Users", description = "Update user")
    @Operation(summary = "Update user", description = "Updates an existing user")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Successful operation",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))
                }
            ),
            @ApiResponse(
                responseCode = "400", description = "Bad request",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "404", description = "User not found",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "500", description = "Internal server error",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "503", description = "Service unavailable",
                content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                }
            )
        }
    )
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto user);
}

