package com.svlt.basics.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class StudentFilter
 */
public class StudentFilter implements Filter {

    public StudentFilter() {
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Inside filter...");
		
		Object rollNo = request.getParameter("rollNo");
		
		if (Integer.parseInt(rollNo.toString()) > 0) {
			chain.doFilter(request, response);
		} else {
			System.out.println("Invalid Roll No Value");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
		
	}

}
