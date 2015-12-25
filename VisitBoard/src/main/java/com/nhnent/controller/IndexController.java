package com.nhnent.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
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
		
		return "index";
	}
	
	@RequestMapping(value = "/writeBoard", method = RequestMethod.GET)
	public String writeBoard(Locale locale, Model model) {
		logger.info("write the board.", locale);
		
		return "writeBoard";
	}
	
	@RequestMapping(value = "/readBoard", method = RequestMethod.GET)
	public String readBoard(Locale locale, Model model) {
		logger.info("read the board.", locale);
		
		return "readBoard";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String goErrorPage(Locale locale, Model model) {
		logger.info("error !!.", locale);
		
		return "error";
	}
}
