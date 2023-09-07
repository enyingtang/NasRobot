package com.nasrobot.repository.repository.auth;

import com.nasrobot.repository.entity.auth.ERole;
import com.nasrobot.repository.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
