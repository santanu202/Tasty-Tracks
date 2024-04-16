package com.santanu.repository;

import com.santanu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u Where u.status='PENDING'")
    public List<User> getPendingRestaurantOwners();

    public User findByEmail(String username);
}