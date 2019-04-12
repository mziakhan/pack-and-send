package com.javarnd.pns.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.model.UserDetail;

@Controller
public class LoginController {
	@GetMapping("/login")
	public ModelAndView showLoginPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		UserDetail userDetail = new UserDetail();
		mav.addObject("action", "./authenticate");
		mav.addObject("command", userDetail);
		return mav;
	}

	@PostMapping("/authenticate")
	public ModelAndView authenticateUser(@ModelAttribute("command") UserDetail userDetail, HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("");
		HttpSession session = request.getSession(true);
		String userName = "admin";
		String password = "admin@123";
		if (userName.equals(userDetail.getUserName()) && password.equals(userDetail.getPassword())) {
			redirectAttributes.addFlashAttribute("successMsg", "Hiii " + userDetail.getUserName());
			mav.setViewName("redirect:/home");
		} else {
			redirectAttributes.addFlashAttribute("errorMsg", "Bad Credentials, Try Again!!");
			mav.setViewName("redirect:/login");
		}
		return mav;
	}

	@GetMapping("/home")
	public ModelAndView showHomePage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/add_company_info");
		CompanyDetails compDetails = new CompanyDetails();
		mav.addObject("command", compDetails);
		mav.addObject("action", "./add_country");
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		mav.setViewName("redirect:/login");
		redirectAttributes.addFlashAttribute("successMsg", "logged out successfully");
		return mav;
	}

}
