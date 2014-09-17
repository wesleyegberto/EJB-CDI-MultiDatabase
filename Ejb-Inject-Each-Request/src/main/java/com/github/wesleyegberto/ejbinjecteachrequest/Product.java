package com.github.wesleyegberto.ejbinjecteachrequest;

public class Product {
	private long id;

	public Product() {
		this.id = System.currentTimeMillis();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id = " + id + "]";
	}
	
}
