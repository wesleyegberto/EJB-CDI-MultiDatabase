package com.github.wesleyegberto.ejbinjecteachrequest;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductStatelessBean {
	
	Product prod;
	
	/** Connection for each Customer (and its logins) */
	Connection connection;

	public ProductStatelessBean() {
		System.out.println("[EJB] ProductStatelessBean created: " + hashCode());
	}

	@Inject
	public void setProduct(Product prod) {
		System.out.println("Setting: " + prod.toString());
		this.prod = prod;
	}
	
	@Inject
	public void setConnection(Connection connection) {
		System.out.println("[EJB] Setting Connection: " + connection);
		this.connection = connection;
	}

	public String getInfo() {
		return "ProductStatelessBean [connection = " + connection + ", prod = " + prod.getId() + ", hashCode = " + hashCode() + "]";
	}
	
}
