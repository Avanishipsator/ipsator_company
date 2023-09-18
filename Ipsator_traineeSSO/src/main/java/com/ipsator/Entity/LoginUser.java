package com.ipsator.Entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The LoginUser class is a JPA entity that represents a logged-in user. It
 * implements the UserDetails interface from Spring Security.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoginUser implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer LoginUserID;
	@Column(unique = true)
	private String email;
	private String name;

	/**
	 * Constructs a new LoginUser with the specified email and name.
	 *
	 * @param email the email of the user
	 * @param name  the name of the user
	 */
	public LoginUser(String email, String name) {
		super();

		this.email = email;
		this.name = name;
	}

	/**
	 * Returns a collection of authorities granted to the user.
	 *
	 * @return a collection of GrantedAuthority
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the password used to authenticate the user.
	 *
	 * @return a string representing the user's password
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the username used to authenticate the user.
	 *
	 * @return a string representing the user's username
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	/**
	 * Checks if the user's account has not expired.
	 *
	 * @return true if the account is not expired, false otherwise
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if the user's account is not locked.
	 *
	 * @return true if the account is not locked, false otherwise
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if the user's credentials are not expired.
	 *
	 * @return true if the credentials are not expired, false otherwise
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if the user is enabled.
	 *
	 * @return true if the user is enabled, false otherwise
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
