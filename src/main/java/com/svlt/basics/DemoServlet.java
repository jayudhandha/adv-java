package com.svlt.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.svlt.basics.model.Student;
import com.svlt.basics.utils.DBUtils;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("rollNo", request.getParameter("rollNo"));
//		try {
//			Connection connection = DBUtils.getConnection();
//
//			if (connection != null) {
//				ResultSet readEntries = DBUtils.readEntries(connection, DBUtils.READ_SPECIFIC_STD_QUERY, params);
//
//				Student std = null;
//				while (readEntries.next()) {
//					std = new Student(readEntries.getString("name"), readEntries.getString("email"), readEntries.getInt("rollNo"));
//				}
//
//				response.getWriter().append("Student Data: ").append(std.toString());
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		ServletContext servletContext = getServletContext();
		
		ServletConfig servletConfig = getServletConfig();
		out.println("DB Name: "+servletConfig.getInitParameter("dbname"));
		out.println("DB Name: "+servletContext.getInitParameter("dbname"));
		
//		out.println("DB User: "+servletContext.getInitParameter("dbuser"));
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside servlet....");
		try {
			Connection connection = DBUtils.getConnection();
			Map<String, Object> params = new LinkedHashMap<String, Object>();
			params.put("name", request.getParameter("name"));
			params.put("email", request.getParameter("email"));
			params.put("rollNo", Integer.parseInt(request.getParameter("rollNo")));
			
			System.out.println(params.toString());
			if (connection != null) {
				int noOfRows = DBUtils.createOrUpdateEntry(connection, DBUtils.CREATE_QUERY, params);

				if (noOfRows > 0) {
					Student std = mapParamsToDao(params);
					
					String encodedName = URLEncoder.encode(std.getName(), "UTF-8");
					
					Cookie cookie = new Cookie("name", encodedName);
					
//					response.addCookie(cookie);
//					
//					response.sendRedirect("studentData");
//					request.setAttribute("student", std);
//					request.getRequestDispatcher("Students.jsp").forward(request, response);
					
					// Session is a server side entity
					HttpSession session = request.getSession();
					System.out.println("[ID ] Insert successful... "+session.getId());
					
					// Below method is used to set session timeout
//					session.setMaxInactiveInterval(noOfRows);
					
					
					session.setAttribute("std", std);
					response.sendRedirect("Students.jsp");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Student mapParamsToDao(Map<String, Object> params) {
		return new Student(params.get("name").toString(), params.get("email").toString(), Integer.parseInt(params.get("rollNo").toString()));
	}
	
	

}
