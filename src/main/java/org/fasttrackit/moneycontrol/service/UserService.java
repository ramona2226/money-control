package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.UserRepository;
import org.fasttrackit.moneycontrol.transfer.SaveUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    //Inversion of Control (IoC)
    private final UserRepository userRepository;


    //Dependency injection
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(SaveUserRequest request) {
        LOGGER.info("Creating User: {}", request);

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        return userRepository.save(user);


    }

    public User getUser(long id) {

        LOGGER.info("Retrieving user{}", id);
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ResourceNotFoundException("User " + id + "does not exist");


        }
    }
}