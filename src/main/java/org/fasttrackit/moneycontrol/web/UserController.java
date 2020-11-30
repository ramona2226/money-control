package org.fasttrackit.moneycontrol.web;

import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.service.UserService;
import org.fasttrackit.moneycontrol.transfer.user.GetUserRequest;
import org.fasttrackit.moneycontrol.transfer.user.SaveUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid SaveUserRequest request) {
        User user = userService.createUser(request);


        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUser(id);

        return ResponseEntity.ok(user);
    }


    @GetMapping
    public ResponseEntity<Page<User>> getUsers(GetUserRequest request, Pageable pageable) {
        Page<User> users = userService.getUsers(request, pageable);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byName")
    public ResponseEntity<Page<User>> getUsersByName(GetUserRequest request, Pageable pageable) {
        Page<User> users = userService.getUsersByName(request, pageable);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody @Valid SaveUserRequest request) {
        User user = userService.updateUser(id, request);
        return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}