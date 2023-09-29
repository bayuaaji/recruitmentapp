package com.dansmultipro.recruitmentapp.repository;

import com.dansmultipro.recruitmentapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByUsername(String username);

    Optional<User> findFirstByEmail(String email);
}
