package com.ipsator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipsator.Entity.User;
import com.ipsator.Exception.UserException;
import com.ipsator.Repository.UserRepo;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepository;

	@Override
	public List<User> getUser() throws UserException {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User DeleteUser(Integer id) throws UserException {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new UserException("User not found with id => " + id));
		userRepository.delete(existingUser);
		return existingUser;
	}

	@Override
	public User getUserByID(Integer id) throws UserException {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(() -> new UserException("User not found with id => " + id));
	}

}
