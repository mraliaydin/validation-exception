package org.aliaydin.validationexception.repository;

import org.aliaydin.validationexception.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
