package com.shklog.api.repository;

import com.shklog.api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);
}
