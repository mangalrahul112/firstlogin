package com.dev.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.spring.mvc.dto.Person;

@Controller
@RequestMapping("/param")
public class HandlingPrarmeters {

	@RequestMapping(value="/query",method=RequestMethod.GET)
	public String getQueryString(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("email") String email,
			Model m
			)
	{
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
		m.addAttribute("name",name);
		m.addAttribute("age",age);
		m.addAttribute("email",email);
		return "Msg";
	}
	
	
	@RequestMapping(value = "/form",method = RequestMethod.GET)
	public String getForm(){
		return "Form";
	}
	
	int i;
	
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	
//	public String getFormData(@RequestParam("id") int id,
//			@RequestParam("name") String name,
//			@RequestParam("age") int age, Model m) 
	
	
//	public String getFormData(Person p, Model m)
	
	
	public String getFormData(Model m, HttpServletRequest req)
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		Person p = new Person();
		p.setAge(age);
		p.setName(name);
		p.setId(id);
		
		m.addAttribute("person",p);
		System.out.println(m);
		return "Msg";
	}
	
	
	@RequestMapping(value="/path/{name}/{age}")
	public String getPathVariable(
			@PathVariable("age") int age,
			@PathVariable("name") String name
			){
		System.out.println(name);
		System.out.println(age);
		return "Msg";
	}
}