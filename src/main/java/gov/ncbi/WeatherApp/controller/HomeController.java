package gov.ncbi.WeatherApp.controller;

import gov.ncbi.WeatherApp.model.Weather;
import gov.ncbi.WeatherApp.service.YahooService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		model.addAttribute("weather", new Weather());
		return "home";
	}

	/**
	 * Where action happens
	 */
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String getReport(@Valid Weather weather, BindingResult result) {
		
		if (!result.hasErrors())
			YahooService.processRequest(weather);
		return "home";
	}
}
