package com.ipsator.Service;

import java.util.List;

import com.ipsator.Entity.User;
import com.ipsator.Exception.UserException;

public interface UserService {

	User addUser(User user) throws UserException;

	User updateUser(User user, Integer id) throws UserException;

	User getUserById(Integer id) throws UserException;

	List<User> getUser() throws UserException;

	User DeleteUser(Integer id) throws UserException;

}
