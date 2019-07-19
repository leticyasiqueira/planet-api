package com.lsiqueira.planet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsiqueira.planet.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByUsername(String name);
}
