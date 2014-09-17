package com.github.wesleyegberto.ejbinjecteachrequest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.wesleyegberto.ejbinjecteachrequest.ProductStatelessBean;

/**
 * Servlet implementation class ProductStatefulServlet
 */
@WebServlet(name = "ProductStatelessServlet", urlPatterns = "/ProductStatelessServlet")
public class ProductStatelessServlet extends HttpServlet {
	private static final long serialVersionUID = 156561565616001L;
    
	@Inject
	ProductStatelessBean bean; // for each request one is created (Wildfly 8.0)
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		System.out.println("============ Incoming request to Stateless ============");
		writer.println("Stateless started at " + System.currentTimeMillis());
		writer.println("EJB: " + bean.getInfo());
	}

}
