package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest/*")
public class GuestController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping("/doA")
	public void doA(){
		
		logger.info("doA...........................");
		
	}
}
