package com.ipsator.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ipsator.Entity.LoginUser;
import com.ipsator.Entity.ServiceResponse;

@RestController

public class UserController {

	@GetMapping("/profile")
	public ResponseEntity<ServiceResponse<LoginUser>> getUserProfile(@AuthenticationPrincipal OAuth2User principal) {
		try {
			String email = principal.getAttribute("email");
			String name = principal.getAttribute("name");
			// You can use the email or any other user identifier to fetch the user profile.
			LoginUser user = new LoginUser(email, name);

			ServiceResponse<LoginUser> response = new ServiceResponse<>(true, user,
					"User profile retrieved successfully");
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ServiceResponse<LoginUser> response = new ServiceResponse<>(false, null, e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
