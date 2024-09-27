package com.meli.interview.back.subscription_api.repository;

import com.meli.interview.back.subscription_api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Long> {
}
