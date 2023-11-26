package com.winzfast.repository;

import com.winzfast.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndEmail(String username, String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
