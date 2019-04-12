package com.javarnd.pns.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.model.DriverDetail;
import com.javarnd.pns.model.Vehicle;
import com.javarnd.pns.service.CompanyDetailService;
import com.javarnd.pns.service.DriverDetailService;
import com.javarnd.pns.service.VehicleService;

@Controller
@RequestMapping("/services")
public class ConsignorController {
	@GetMapping("/consignor")
	public ModelAndView showPostResourceForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("consignor/pas_post_resources");
		DriverDetail driverDetail = new DriverDetail();
		Vehicle vehicle = new Vehicle();
		List<CompanyDetails> compList = null;
		try {
			compList = compService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("isConsignor", true);
		mav.addObject("isConsignee", false);
		mav.addObject("cList", compList);
		mav.addObject("command1", vehicle);
		mav.addObject("command2", driverDetail);
		return mav;

	}

	@PostMapping("/saveVehicleDetail")
	public ModelAndView saveInfo(@ModelAttribute("command1") Vehicle vehicle, HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("");
		Vehicle vehicleDetail = new Vehicle();
		CompanyDetails compDetails = new CompanyDetails();
		vehicleDetail.setVehicleType(vehicle.getVehicleType());
		vehicleDetail.setMake(vehicle.getMake());
		vehicleDetail.setModel(vehicle.getModel());
		vehicleDetail.setRegNo(vehicle.getRegNo());
		vehicleDetail.setVehicleNumber(vehicle.getVehicleNumber());
		vehicleDetail.setMfgDate(vehicle.getMfgDate());
		compDetails.setCompanyId(Long.parseLong(request.getParameter("companyId").trim()));
		vehicleDetail.setCompanyDetail(compDetails);
		try {
			vehicleService.save(vehicleDetail);
			redirectAttributes.addFlashAttribute("successMsg1", "Vehicle Details Saved Successfully");
			mav.setViewName("redirect:./consignor");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMsg1", "Failed To Add Record");
			mav.setViewName("redirect:./consignor");
		}
		return mav;
	}

	@PostMapping("/saveDriverDetail")
	public ModelAndView saveInfo(@ModelAttribute("command2") DriverDetail driverDetail, HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("");
		CompanyDetails compDetails = new CompanyDetails();
		DriverDetail driver = new DriverDetail();
		try {
			driver.setName(driverDetail.getName());
			driver.setContactNo(driverDetail.getContactNo());
			driver.setLicenseNo(driverDetail.getLicenseNo());
			compDetails.setCompanyId(Long.parseLong(request.getParameter("companyId").trim()));
			driver.setCompanyDetail(compDetails);
			driverService.save(driver);
			redirectAttributes.addFlashAttribute("successMsg2", "Driver Details Saved Successfully");
			mav.setViewName("redirect:./consignor");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMsg2", "Failed To Add Record");
			mav.setViewName("redirect:./consignor");
		}
		return mav;
	}

	@Autowired
	CompanyDetailService compService;

	@Autowired
	VehicleService vehicleService;

	@Autowired
	DriverDetailService driverService;
}
