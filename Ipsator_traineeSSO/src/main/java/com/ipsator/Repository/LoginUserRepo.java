package com.ipsator.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipsator.Entity.LoginUser;

@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, Integer> {
	Optional<LoginUser> findByEmail(String email);
}
