package com.javarnd.pns.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.model.Vehicle;
import com.javarnd.pns.service.CompanyDetailService;
import com.javarnd.pns.service.VehicleService;

@Controller
@RequestMapping("/services")
public class ConsigneeController {

	@GetMapping("/consignee")
	public ModelAndView showRequestConsignmentForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("consignee/cas-request_service");
		List<CompanyDetails> compList = null;
		try {
			compList = compService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("isConsignee", true);
		mav.addObject("cList", compList);
		return mav;
	}

	@GetMapping("searchVehiceList")
	@ResponseBody
	public List<Vehicle> getVehicleListForCompany(@RequestParam("companyId") String companyId) {
		List<Vehicle> vList=null;
		long compId = Long.parseLong(companyId.trim());
		try {
			vList = vehicleService.findByCompanyId(compId);
			return vList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Autowired
	CompanyDetailService compService;

	@Autowired
	VehicleService vehicleService;
}