package com.javarnd.pns.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarnd.cip.util.DateUtility;
import com.javarnd.pns.enums.ResourceEnum;
import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.model.DriverDetail;
import com.javarnd.pns.model.Vehicle;
import com.javarnd.pns.service.CompanyDetailService;
import com.javarnd.pns.service.DriverDetailService;
import com.javarnd.pns.service.VehicleService;

/**
 * Servlet implementation class MainServiceServlet
 */
public class MainServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CompanyDetailService compService = new CompanyDetailService();
	private VehicleService vehicleService = new VehicleService();
	private DriverDetailService ddService = new DriverDetailService();

	public MainServiceServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUrl = request.getParameter("s");
		switch (requestUrl) {
		case "Consignor":
			showConsignorServicePage(request, response);
			break;
		case "Consignee":
			showConsigneeServicePage(request, response);
			break;
		case "vList":
			getVehicleListOfCompany(request, response);
			break;
		case "addVehicle":
			saveVehicleInfo(request, response);
			break;
		case "addDriver":
			addDriverInfo(request, response);
			break;
		case "saveInfo":
			saveDriverInfo(request, response);
			break;

		}

	}

	private void getVehicleListOfCompany(HttpServletRequest request, HttpServletResponse response) {
		String companyId = request.getParameter("companyId");
		System.out.println("company id" + companyId);
//		response.setContentType("application/json");
//		new Gson().toJson(list2, response.getWriter());
	}

	private void showConsignorServicePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<CompanyDetails> companyList = compService.findAll();
			request.setAttribute("cList", companyList);
			request.setAttribute("consignor", true);
			request.setAttribute("admin", false);
			request.getRequestDispatcher(
					ResourceEnum.RESOURCE_PATH.getName() + "consignor/pas_post_vehicle_resources.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void showConsigneeServicePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<CompanyDetails> companyList = compService.findAll();
			request.setAttribute("cList", companyList);
			request.setAttribute("admin", false);
			request.setAttribute("consignor", false);
			request.getRequestDispatcher(ResourceEnum.RESOURCE_PATH.getName() + "consignee/cas-request_service.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void saveVehicleInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			long companyId = Long.valueOf(request.getParameter("companyId").trim());
			String vehicleType = request.getParameter("vehicleType");
			String vehicleMake = request.getParameter("vehicleMake");
			String vehicleModel = request.getParameter("vehicleModel");
			String regNo = request.getParameter("regNo");
			String vehicleNumber = request.getParameter("vehicleNumber");
			String mfgDate = request.getParameter("mfgDate");

			CompanyDetails companyDetails = new CompanyDetails();
			companyDetails.setCompanyId(companyId);
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleType(vehicleType);
			vehicle.setMake(vehicleMake);
			vehicle.setModel(vehicleModel);
			vehicle.setRegNo(regNo);
			vehicle.setVehicleNumber(vehicleNumber);
			vehicle.setMfgDate(DateUtility.stringToSQLDate(mfgDate));
			vehicle.setCompanyDetail(companyDetails);
			vehicleService.save(vehicle);
			response.sendRedirect(request.getHeader("Referer"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addDriverInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<CompanyDetails> companyList = compService.findAll();
			request.setAttribute("cList", companyList);
			request.getRequestDispatcher(
					ResourceEnum.RESOURCE_PATH.getName() + "consignor/pas_post_driver_resources.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void saveDriverInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			long companyId = Long.valueOf(request.getParameter("companyId").trim());
			String driverName = request.getParameter("driverName");
			String contactNo = request.getParameter("contactNo");
			String licenseNo = request.getParameter("licenseNo");
			CompanyDetails companyDetails = new CompanyDetails();
			companyDetails.setCompanyId(companyId);
			DriverDetail driverDetail = new DriverDetail();
			driverDetail.setName(driverName);
			driverDetail.setContactNo(contactNo);
			driverDetail.setLicenseNo(licenseNo);
			driverDetail.setCompanyDetail(companyDetails);
			ddService.save(driverDetail);
			response.sendRedirect(request.getHeader("Referer"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
