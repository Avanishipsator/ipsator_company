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
	public User addUser(User user) throws UserException {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findByUsernamUser(user.getUserName());

		if (existingUser != null) {
			throw new UserException("User already exist with this username => " + user.getUserName());
		} else {
			return userRepository.save(user);
		}
	}

	@Override
	public User updateUser(User user, Integer id) throws UserException {

		User existingUser = userRepository.findById(id).orElse(null);

		if (existingUser != null) {
			existingUser.setUserName(user.getUserName());
			// Set other fields as needed
			return userRepository.save(existingUser);
		} else {
			throw new UserException("User not found with id => " + id);
		}
	}

	@Override
	public User getUserById(Integer id) throws UserException {
		return userRepository.findById(id).orElseThrow(() -> new UserException("User not found with id => " + id));
	}

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

}
