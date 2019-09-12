package com.dev.spring.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/controller")
public class HomeController {
	
	
	@RequestMapping(value="/msg" ,method= RequestMethod.GET)
	public String hello() {
		return "Msg";
	}
	@RequestMapping(value= {"/hi","/hello","/hey"},
			method= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
	public String sayHi() {
		return "Hello";
	}

	@RequestMapping(value="/motive",method=RequestMethod.GET)
	@ResponseBody
	public String saySomething() {
		return "do or die";
	}
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String passAttribute(Model model) {
		model.addAttribute("name", "Rah"); //req.setAttribute("name","Rah");
		return "Info";
	}
	
	@RequestMapping(value="/info2",method=RequestMethod.GET)
	public ModelAndView passAttribute2() {
		return new ModelAndView("Info", "name", "Rah");
	}
	
	@RequestMapping(value="/info3",method=RequestMethod.GET)
	public ModelAndView passAttribute3(ModelAndView modelAndView) {
		modelAndView.addObject("name", "Rah");
		modelAndView.setViewName("Info");
		return modelAndView;
	}
	

}
