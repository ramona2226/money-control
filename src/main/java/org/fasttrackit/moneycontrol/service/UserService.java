package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.persistance.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

public User createUser() {
    LOGGER.info("Creating User: {}" , request);

    User user = new User();
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());

     return userRepository.save(user);



    }



}
