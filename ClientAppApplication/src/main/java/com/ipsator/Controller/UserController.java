package com.ipsator.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ipsator.Entity.User;
import com.ipsator.Exception.UserException;
import com.ipsator.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate; // You may need to configure RestTemplate

	@Autowired
	private UserService userService; // Assuming you have a UserService

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		try {
			User addedUser = userService.addUser(user);
			return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
		} catch (UserException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
		try {
			User updatedUser = userService.updateUser(user, id);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} catch (UserException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		try {
			User user = userService.getUserById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (UserException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers() {
		try {
			List<User> users = userService.getUser();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (UserException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
		try {
			User deletedUser = userService.DeleteUser(id);
			return new ResponseEntity<>(deletedUser, HttpStatus.OK);
		} catch (UserException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		// Send a POST request to the AuthController for signup
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> request = new HttpEntity<>(user, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://auth-service/auth/signup", HttpMethod.POST,
				request, String.class);

		return response;
	}

	@PostMapping("/signin")
	public ResponseEntity<String> signin(@RequestBody Map<String, String> userData) {
		// Send a POST request to the AuthController for signin
		// Include the origin URL for redirection
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, String>> request = new HttpEntity<>(userData, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://auth-service/auth/signin?originUrl=http://user-app/redirect", HttpMethod.POST, request,
				String.class);

		return response;
	}

	@GetMapping("/redirect")
	public ResponseEntity<String> redirect() {
		// In this example, redirection happens after signin via AuthController
		// The AuthController will redirect back to this endpoint
		return ResponseEntity.ok("Redirected to User App");
	}
}
