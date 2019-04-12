package com.javarnd.pns.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.pns.enums.ResourceEnum;
import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.service.CompanyDetailService;

public class AdminActionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CompanyDetailService compService = new CompanyDetailService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUrl = request.getParameter("requestUrl");

		switch (requestUrl) {
		case "save":
			saveCountryInfo(request, response);
			break;
		}
	}

	private void saveCountryInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			String companyName = request.getParameter("companyName");
			String contactNo = request.getParameter("contact");
			String email = request.getParameter("email");
			String panNo = request.getParameter("panNo");
			String website = request.getParameter("website");
			CompanyDetails compDetails = new CompanyDetails();
			compDetails.setCompanyName(companyName);
			compDetails.setContactNo(contactNo);
			compDetails.setEmail(email);
			compDetails.setPanNo(panNo);
			compDetails.setWebsite(website);
			compService.save(compDetails);
			request.getRequestDispatcher(ResourceEnum.RESOURCE_PATH.getName() + "admin/add_company_info.jsp")
					.forward(request, response);
//			response.sendRedirect(request.getHeader("Referer"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
