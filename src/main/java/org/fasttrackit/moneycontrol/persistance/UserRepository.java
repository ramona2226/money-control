package org.fasttrackit.moneycontrol.persistance;

import org.fasttrackit.moneycontrol.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
