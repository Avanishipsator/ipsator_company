package com.ipsator.Service;

import java.util.List;

import com.ipsator.Entity.LoginUser;

public interface LoginUserService {

	LoginUser saveUser(LoginUser lu);

	LoginUser getUserById(Integer id);

	List<LoginUser> getAllUserDetails();

}
