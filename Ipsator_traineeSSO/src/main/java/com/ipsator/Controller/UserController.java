package com.ipsator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ipsator.Entity.LoginUser;
import com.ipsator.Entity.ServiceResponse;
import com.ipsator.Service.LoginUserService;

/**
 * The UserController class is a REST controller that handles various operations
 * related to user profiles. It uses Spring's ResponseEntity to return data and
 * HTTP status codes.
 */
@RestController

public class UserController {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private LoginUserService lu;

	/**
	 * Retrieves the user's profile using the provided OAuth2User principal. If
	 * successful, it returns a ServiceResponse with the user's profile and a
	 * success message. If an exception occurs, it returns a ServiceResponse with an
	 * error message and a status of INTERNAL_SERVER_ERROR.
	 *
	 * @param principal OAuth2User
	 * @return ResponseEntity<ServiceResponse<LoginUser>>
	 */
	@GetMapping("/profile")
	public ResponseEntity<ServiceResponse<LoginUser>> getUserProfile(@AuthenticationPrincipal OAuth2User principal) {
//		System.out.println(principal);
		try {
			String email = principal.getAttribute("email");
			String name = principal.getAttribute("name");

			System.out.println("all : " + email + "  " + name);

			LoginUser savedLoggedInUser = lu.saveUser(new LoginUser(email, name));

			System.out.println("after : " + email + "  " + name);
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);

			ServiceResponse<LoginUser> response = new ServiceResponse<>(true, savedLoggedInUser,
					"User profile retrieved successfully ! ");

			return ResponseEntity.ok().body(response);

		} catch (Exception e) {
			ServiceResponse<LoginUser> response = new ServiceResponse<>(false, null, e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	/**
	 * Retrieves all user details and returns them in a ServiceResponse with a
	 * success message.
	 *
	 * @return ResponseEntity<ServiceResponse<List<LoginUser>>>
	 */
	@GetMapping("/AllLogInUser")
	public ResponseEntity<ServiceResponse<List<LoginUser>>> getAllUserDetails() {
		List<LoginUser> AllUser = lu.getAllUserDetails();
		ServiceResponse<List<LoginUser>> slu = new ServiceResponse<>(true, AllUser + "List Of All Logged In User!");
		return new ResponseEntity<>(slu, HttpStatus.ACCEPTED);

	}

	/**
	 * Retrieves a user's profile by their ID. If the user is found, it returns a
	 * ServiceResponse with the user's profile and a success message. If the user is
	 * not found, it returns a ServiceResponse with an error message.
	 *
	 * @param id Integer
	 * @return ResponseEntity<ServiceResponse<LoginUser>>
	 */
	@GetMapping("/profile/{id}")
	public ResponseEntity<ServiceResponse<LoginUser>> getUserById(@PathVariable Integer id) {
		LoginUser LgUser = lu.getUserById(id);
		if (LgUser != null) {
			ServiceResponse<LoginUser> response = new ServiceResponse<>(true, LgUser,
					"User profile retrieved successfully ");

			return ResponseEntity.ok().body(response);
		} else {
			ServiceResponse<LoginUser> response = new ServiceResponse<>(false, null,
					"No User profile retrieved with ID " + id);

			return ResponseEntity.ok().body(response);
		}
	}
}
