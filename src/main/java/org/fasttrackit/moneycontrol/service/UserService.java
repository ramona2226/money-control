package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.UserRepository;
import org.fasttrackit.moneycontrol.transfer.GetUsersRequest;
import org.fasttrackit.moneycontrol.transfer.SaveUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



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


        return userRepository.findById(id)
                //Lambda expression
                .orElseThrow(()-> new ResourceNotFoundException(("User " + id + "does not exist")));
    }

    public Page<User> getUsers(GetUsersRequest request, Pageable pageable) {
        LOGGER.info("Retriving  users");


        return userRepository.findByOptionalCriteria(
                request.getPartialFirstName(), request.getPartialLastName(), pageable);
    }

    public User updateUser(long id, SaveUserRequest request){

            LOGGER.info("Updating user {}: {}", id, request);


        User existingUser = getUser(id);
        BeanUtils.copyProperties(request, existingUser);

        return userRepository.save(existingUser);

    }
    public void deleteUser(long id) {
        LOGGER.info("Deleting user {} ", id);
        userRepository.deleteById(id);
    }

}