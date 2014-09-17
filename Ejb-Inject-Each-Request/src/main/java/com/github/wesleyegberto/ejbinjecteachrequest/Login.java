package com.github.wesleyegberto.ejbinjecteachrequest;

public class Login {
	private int customerId;
	private String username;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Login [customerId = " + customerId + ", username = " + username + "]";
	}

}
