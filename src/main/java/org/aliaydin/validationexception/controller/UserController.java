package org.aliaydin.validationexception.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.aliaydin.validationexception.dto.UserRequest;
import org.aliaydin.validationexception.entity.User;
import org.aliaydin.validationexception.exception.UserNotFoundException;
import org.aliaydin.validationexception.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
