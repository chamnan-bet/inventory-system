package com.chamnan.inventory_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chamnan.inventory_system.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    // Custom finder: only return user if enabled = true (1)
    Optional<User> findByUserIdAndEnabled(Long userId, boolean enabled);

    Page<User> findByEnabledTrue(Pageable pageable);
}
