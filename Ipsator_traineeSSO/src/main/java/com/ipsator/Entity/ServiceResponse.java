package com.ipsator.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse<T> {

	private boolean status;
	private T data;
	private String message;

	public ServiceResponse(boolean status) {
		this.status = status;
	}

	public ServiceResponse(boolean status, T data) {
		this.status = status;
		this.data = data;
	}

	public ServiceResponse(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
}
