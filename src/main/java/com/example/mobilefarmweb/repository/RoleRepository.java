package com.example.mobilefarmweb.repository;

import com.example.mobilefarmweb.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);
	Optional<Role> findById(Integer id);
}
