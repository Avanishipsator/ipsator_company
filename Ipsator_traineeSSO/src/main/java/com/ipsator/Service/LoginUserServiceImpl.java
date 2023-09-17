package com.ipsator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipsator.Entity.LoginUser;
import com.ipsator.Repository.LoginUserRepo;

@Service
public class LoginUserServiceImpl implements LoginUserService {
	@Autowired
	private LoginUserRepo loginUserRep;

	@Override
	public LoginUser getUserById(Integer id) {
		// TODO Auto-generated method stub
		return loginUserRep.findById(id).orElseThrow();

	}

	@Override
	public List<LoginUser> getAllUserDetails() {
		// TODO Auto-generated method stub
		return loginUserRep.findAll();

	}

	@Override
	public LoginUser saveUser(LoginUser lu) {
		// TODO Auto-generated method stub
		return loginUserRep.save(lu);

	}

}
