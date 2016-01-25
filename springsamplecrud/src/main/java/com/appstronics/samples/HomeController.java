package com.appstronics.samples;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value ="/hello", method = RequestMethod.GET)
	public ModelAndView setHello(HttpSession session)
	{
		ModelAndView mv = new ModelAndView("hello");
		Map<String, Object> attrModal = mv.getModel();
		session.setAttribute("name", "sajin");
		attrModal.put("password", "white");
		return mv;
	}
	
	@RequestMapping(value ="/test", method = RequestMethod.GET)
	public String setTest(Model model, @RequestParam("Id")String Id)
	{
		model.addAttribute("user", "sajin");
		model.addAttribute("password", "white");
		System.out.println("Id:"+Id);
		return "home";
	}
	

}
