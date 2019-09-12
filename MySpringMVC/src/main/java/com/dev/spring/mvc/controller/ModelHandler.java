package com.dev.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/assign")
public class ModelHandler {
	@ModelAttribute(name= "clglist")
    public List<String> populateCountries() {
 
        List<String> clg= new ArrayList<String>();
        clg.add("Iim");
        clg.add("IIT");
        clg.add("MBM");
        clg.add("NIT");
        clg.add("Oxford");     
 
        return clg;
    }
 

    @RequestMapping(value= "/init", method= RequestMethod.GET)
    public ModelAndView initView(@ModelAttribute(name= "clglist") List<String> clg) {
 
        ModelAndView modelview = new ModelAndView();
        modelview.addObject("message", "This is an example of using the @ModelAttribute annotation .....!");
        modelview.setViewName("Demo");
 
        return modelview;
    }
   
}
