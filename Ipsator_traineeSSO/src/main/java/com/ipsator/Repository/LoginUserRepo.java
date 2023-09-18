package com.ipsator.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipsator.Entity.LoginUser;

/**
 * The LoginUserRepo interface is a Spring Data JPA repository for LoginUser
 * entities. It extends JpaRepository, which provides methods for CRUD
 * operations.
 */
@Repository
public interface LoginUserRepo extends JpaRepository<LoginUser, Integer> {

	/**
	 * Finds a LoginUser by their email.
	 *
	 * @param email the email of the user
	 * @return an Optional containing the LoginUser if found, or an empty Optional
	 *         if not found
	 */
	Optional<LoginUser> findByEmail(String email);
}
