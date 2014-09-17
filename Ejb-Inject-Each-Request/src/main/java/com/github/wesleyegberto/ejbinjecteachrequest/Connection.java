package com.github.wesleyegberto.ejbinjecteachrequest;

/**
 * Class to simulate the connection shared between the users from the same
 * customer.
 */
public class Connection {

	private int id;
	private String database;

	public Connection(int id, String database) {
		this.id = id;
		this.database = database;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@Override
	public String toString() {
		return "Connection [id = " + id + ", database = " + database + ", hashCode = " + hashCode() + "]";
	}

}
