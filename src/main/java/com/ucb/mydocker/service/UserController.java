package com.ucb.mydocker.service;
import com.ucb.mydocker.dto.UserDto;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

import org.springframework.http.ResponseEntity;

@RestController
public class UserController implements IUserApi {

    @GetMapping("/users")
    public String getUsers() {
        return "Lista de usuarios";
    }

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        UserDto user = new UserDto(1, "John", "john@example.com", "password123");
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/users", produces = "application/json")
    public ResponseEntity createUser(@RequestBody UserDto user) {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(user);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(UserController.class.getClassLoader().getResourceAsStream("schemas/user.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

            String errorsCombined = "";
            for (ValidationMessage error : errors) {
                errorsCombined += error.toString() + "\n";
            }

            if (errors.size() > 0) {
                return ResponseEntity.badRequest().body("Please fix your JSON!,\n" + errorsCombined);
            }
            return ResponseEntity.ok(user);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error processing JSON");
        }
    }
     @PutMapping(value = "/users/{id}", produces = "application/json")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto user) {
        // Aquí irá la lógica para actualizar el usuario con el ID proporcionado
        // Por ahora, simplemente devolveremos el usuario que recibimos en la solicitud
        return ResponseEntity.ok(user);
    }
}
