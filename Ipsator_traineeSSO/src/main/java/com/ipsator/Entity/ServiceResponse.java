package com.ipsator.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ServiceResponse class is a generic class for creating service responses.
 * It includes a status, data of type T, and a message.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse<T> {

	private boolean status;
	private T data;
	private String message;

	/**
	 * Constructs a new ServiceResponse with the specified status.
	 *
	 * @param status the status of the response
	 */
	public ServiceResponse(boolean status) {
		this.status = status;
	}

	/**
	 * Constructs a new ServiceResponse with the specified status and data.
	 *
	 * @param status the status of the response
	 * @param data   the data of the response
	 */
	public ServiceResponse(boolean status, T data) {
		this.status = status;
		this.data = data;
	}

	/**
	 * Constructs a new ServiceResponse with the specified status and message.
	 *
	 * @param status  the status of the response
	 * @param message the message of the response
	 */
	public ServiceResponse(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
}
