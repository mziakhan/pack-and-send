package com.javarnd.pns.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.service.CompanyDetailService;

/**
 * Servlet Filter implementation class ExcecuteTimeFilter
 */
public class ExcecuteTimeFilter implements Filter {
	private CompanyDetailService compService = new CompanyDetailService();

	/**
	 * Default constructor.
	 */
	public ExcecuteTimeFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		RequestDispatcher rdObj = null;
		List<CompanyDetails> companyList = null;
		try {
			companyList = compService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("inside filter");
		request.setAttribute("companyList",companyList );
		rdObj = request.getRequestDispatcher("/");
		rdObj.include(request, response);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
