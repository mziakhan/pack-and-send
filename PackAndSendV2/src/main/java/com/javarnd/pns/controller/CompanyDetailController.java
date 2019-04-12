package com.javarnd.pns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.service.CompanyDetailService;

@Controller
public class CompanyDetailController {

	@PostMapping("/add_country")
	public ModelAndView saveCountryDetail(@ModelAttribute("command") CompanyDetails compDetails,
			final RedirectAttributes redirectAttributes) {
		System.out.println("method called");
		ModelAndView mav = new ModelAndView("");
		CompanyDetails cDetails = new CompanyDetails();
		try {
			cDetails.setCompanyName(compDetails.getCompanyName());
			cDetails.setContactNo(compDetails.getContactNo());
			cDetails.setEmail(compDetails.getEmail());
			cDetails.setPanNo(compDetails.getPanNo());
			cDetails.setWebsite(compDetails.getWebsite());
			compService.save(cDetails);
			redirectAttributes.addFlashAttribute("successMsg", "Record added successfully");
			mav.setViewName("redirect:/home");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMsg", "Failed to Add record");
			mav.setViewName("redirect:/home");
		}
		return mav;
	}

	@Autowired
	CompanyDetailService compService;
}