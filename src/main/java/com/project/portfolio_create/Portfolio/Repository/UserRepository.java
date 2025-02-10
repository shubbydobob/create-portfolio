package com.project.portfolio_create.Portfolio.Repository;

import com.project.portfolio_create.Portfolio.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,String> {
    Optional<Users> findByUserId(String userId);
}
