package com.ipsator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipsator.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	 User findByUsernamUser(String Username);
}
