package com.wmdigital.menu_springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wmdigital.menu_springboot.framework.AbstractController;
import com.wmdigital.menu_springboot.framework.AbstractEntityService;

@Controller
public class IndexController extends AbstractController<Object> {

	
//	@Autowired
//	private  PasswordEncoder encoder;
//	
//	@Autowired
//	private AutService autService;
	

	protected IndexController() {
		super("home", Object::new);
		
	}
	
    @GetMapping({"/", "/index"})
    public ModelAndView index() {
    	   	 
   	    ModelAndView mav = new ModelAndView("index");
   	   
        return mav;
    }
    
    
//    @GetMapping({"/login"})
//    public ModelAndView login() {
//    	
//    	   	 
//   	    ModelAndView mav = new ModelAndView("login");
////   	    mav.addObject("modelos", modelos);
//   	  
//        return mav;
//    }
//    
//    @GetMapping({"/dashboard"})
//    public ModelAndView dashboard() {
//    	
//   	    ModelAndView mav = new ModelAndView("private/dashboard");
//   	    
//	    
//        return mav;
//    }
//    
	@Override
	protected Object createEmptyEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractEntityService<Object> getService() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

