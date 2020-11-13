package org.fasttrackit.moneycontrol.persistance;

import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.transfer.user.GetUserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {



    Page<User> findByFirstNameContains(String partialFirstName, Pageable pageable);

    Page<User> findByLastNameContains(String partialLastName, Pageable pageable);



    //dintr-o metoda custom query
    //JPQL JAVA PERSISTANCE QUERY LEVEL
    @Query(value = "SELECT user FROM User user" +
            " Where (:partialFirstName IS NULL OR user.firstName LIKE %:partialFirstName%) " +
            " AND (:partialLastName IS NULL OR user.lastName LIKE %:partialFirstName%)")
    Page<User> findByOptionalCriteria(String partialFirstName, String partialLastName, Pageable pageable);


    User findAllByFirstNameAndLastName( String firstName, String lastName);

}

