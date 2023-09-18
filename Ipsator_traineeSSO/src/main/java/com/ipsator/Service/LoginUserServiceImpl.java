package com.ipsator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipsator.Entity.LoginUser;
import com.ipsator.Repository.LoginUserRepo;

/**
 * The LoginUserServiceImpl class is a service that implements the
 * LoginUserService interface. It provides methods for retrieving and saving
 * LoginUser entities.
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private LoginUserRepo loginUserRep;

	/**
	 * Retrieves a LoginUser by their ID.
	 *
	 * @param id the ID of the user
	 * @return the LoginUser with the specified ID
	 */
	@Override
	public LoginUser getUserById(Integer id) {
		return loginUserRep.findById(id).orElseThrow();
	}

	/**
	 * Retrieves all LoginUser entities.
	 *
	 * @return a list of all LoginUser entities
	 */
	@Override
	public List<LoginUser> getAllUserDetails() {
		return loginUserRep.findAll();
	}

	/**
	 * Saves a LoginUser entity.
	 *
	 * @param lu the LoginUser entity to save
	 * @return the saved LoginUser entity
	 */
	@Override
	public LoginUser saveUser(LoginUser lu) {
		return loginUserRep.save(lu);
	}
}
