package com.github.wesleyegberto.ejbinjecteachrequest;

import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
public class ProductStatefulBean {
	
	Product prod;

	public ProductStatefulBean() {
		System.out.println("[EJB] ProductStatefulBean created: " + hashCode());
	}

	@Inject
	public void setProduct(Product prod) {
		System.out.println("Setting: " + prod.toString());
		this.prod = prod;
	}

	public String getInfo() {
		return "ProductStatefulBean [prod = " + prod.getId() + ", hashCode = " + hashCode() + "]";
	}
	
}
