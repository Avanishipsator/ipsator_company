package com.ipsator.Service;

import java.util.List;

import com.ipsator.Entity.User;
import com.ipsator.Exception.UserException;

public interface UserService {

	List<User> getUser() throws UserException;

	User DeleteUser(Integer id) throws UserException;

	User getUserByID(Integer id) throws UserException;

}
