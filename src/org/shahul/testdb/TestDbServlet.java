package org.shahul.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			PrintWriter writer = response.getWriter();
			Class.forName("org.postgresql.Driver");
			writer.println("Testing...");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/hbStudentDB","postgres","admin");
			writer.println("Success"+connection);
			connection.close();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
