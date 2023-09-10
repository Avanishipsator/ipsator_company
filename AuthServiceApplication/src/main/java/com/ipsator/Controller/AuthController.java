package com.ipsator.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipsator.Entity.User;
import com.ipsator.Repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepo userRepository;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		userRepository.save(user);
		return ResponseEntity.ok("Signup successful.");
	}

	@PostMapping("/signin")
	public ResponseEntity<String> signin(@RequestBody Map<String, String> credentials, HttpServletRequest request) {
		String username = credentials.get("userName");
		String password = credentials.get("userPassword");

		User user = userRepository.findByUsernamUser(username);

		if (user != null && user.getUserPassword().equals(password)) {
			// User authentication is successful

			// Store user information in the session
			request.getSession().setAttribute("user", user);

			return ResponseEntity.ok("Signin successful.");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
		}
	}

//	@GetMapping("/redirect")
//	public ResponseEntity<String> redirect(HttpServletRequest request) {
//		User user = (User) request.getSession().getAttribute("user");
//
//		if (user != null) {
//			String originUrl = user.getOriginUrl();
//			if (originUrl != null && !originUrl.isEmpty()) {
//				return ResponseEntity.status(HttpStatus.FOUND).header("Location", originUrl).body("");
//			}
//		}
//
//		return ResponseEntity.badRequest().body("Invalid or missing origin URL.");
//	}
}