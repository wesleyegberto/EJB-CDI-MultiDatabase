package com.github.wesleyegberto.ejbinjecteachrequest;

import java.util.Map;
import java.util.TreeMap;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * EJB which has a pool of the Connections.
 */
@Singleton
public class ConnectionFactory {

	private Map<Integer, Connection> connections = new TreeMap<Integer, Connection>();

	@Produces
	public Connection getConnection() {
		Login loginFromSession = getLoginFromSession();
		if(loginFromSession != null) {
			// if isn't pooled should get from the database again
			return connections.get(loginFromSession.getCustomerId());
		}
		return null;
	}
	
	/**
	 * Verify if exist a Connection for the given customer ID.
	 */
	public boolean hasConnectionInPool(int customerId) {
		return connections.containsKey(customerId);
	}
	
	/**
	 * Insert a Connection in the pool. 
	 */
	public void putConnection(int customerId, Connection conn) {
		connections.put(customerId, conn);
	}
	
	/** The methods should be in another place, but for while is here */
	@Produces
	public Login getLoginFromSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if(session != null) {
			Login login = (Login) session.getAttribute("login");
			System.out.println("Login peeked from Session: " + login);
			return login;
		}
		return null;
	}
	
	public void startSessionTo(Login login) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("login", login);
	}
	
}
