package com.github.wesleyegberto.ejbinjecteachrequest.jsf;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.wesleyegberto.ejbinjecteachrequest.Connection;
import com.github.wesleyegberto.ejbinjecteachrequest.ConnectionFactory;
import com.github.wesleyegberto.ejbinjecteachrequest.Login;
import com.github.wesleyegberto.ejbinjecteachrequest.ProductStatelessBean;

@Named
@ViewScoped
public class IndexController implements Serializable {
	private static final long serialVersionUID = 2413823502850130861L;

	ProductStatelessBean bean;

	@Inject
	ConnectionFactory connFact;
	
	private Login login;

	public IndexController() {
		System.out.println("[JSF] IndexController created: " + hashCode());
	}

	@Inject
	public void setBean(ProductStatelessBean bean) {
		System.out.println("[JSF] Setting: " + bean.getInfo());
		this.bean = bean;
	}

	public String getInfo() {
		return bean.getInfo();
	}

	public Login getLogin() {
		if(login == null) {
			login = new Login();
		}
		return login;
	}

	public void signIn() {
		connFact.startSessionTo(login);
		// verify if the Connection is already pooled
		if(!connFact.hasConnectionInPool(login.getCustomerId())) {
			// should get the connection data from database
			Connection conn = new Connection(login.getCustomerId(), "DB_CUSTOMER_" + login.getCustomerId());
			connFact.putConnection(login.getCustomerId(), conn);
		}
	}

}
