package com.dev.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/assign1")
public class RequestHeaderExampleController
{
    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String  getHello(@RequestHeader ("host") String hostName,
    		@RequestHeader ("Accept") String acceptType,
    		@RequestHeader ("Accept-Language") String acceptLang,
    		@RequestHeader ("Accept-Encoding") String acceptEnc,
    		@RequestHeader ("Cookie") String cookie,
    		@RequestHeader ("User-Agent") String userAgent,
    		Model m)
    {
    	System.out.println("Host : " + hostName);
    	System.out.println("Accept : " + acceptType);
    	System.out.println("Accept Language : " + acceptLang);
    	System.out.println("Accept Encoding : " + acceptEnc);
    	System.out.println("Cookie : " + cookie);
    	System.out.println("User-Agent : " + userAgent);
    	m.addAttribute("Host",hostName);
		m.addAttribute("Accept",acceptType);
		m.addAttribute("Accept Language",acceptLang);
    	m.addAttribute("Accept Encoding",acceptEnc);
		m.addAttribute("Cookie",cookie);
		m.addAttribute("User-Agent",userAgent);

	
        return "Msg";
    }
}