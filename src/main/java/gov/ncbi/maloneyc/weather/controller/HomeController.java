package gov.ncbi.maloneyc.weather.controller;

import gov.ncbi.maloneyc.weather.model.Weather;
import gov.ncbi.maloneyc.weather.service.YahooService;

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
    
    // Helper function:  get the time and add it to the model
    private void getCurrentTime(Locale locale, ModelMap model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        logger.info("current time is " + formattedDate);
        model.addAttribute("serverTime", formattedDate );
    }
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, ModelMap model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        getCurrentTime(locale, model);
        
        model.addAttribute("weather", new Weather());
        return "home";
    }

    /**
     * Where action happens
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, params = {"zipcode"})
    public String getReport(Locale locale, @Valid Weather weather, BindingResult result) {
        System.out.println("In home, weather is " + weather + ", zip code is " + weather.getZipcode());
        System.out.println("result.hasErrors() is " + result.hasErrors());
        //getCurrentTime(locale, model);
        
        if (!result.hasErrors())
            YahooService.processRequest(weather);
        return "home";
    }
}
