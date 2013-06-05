package com.ninja_squad.geektic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/geeks")
public class GeekController {
	
	@Autowired
	GeekService geekService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView listSpec = new ModelAndView("Spectacles");
		listSpec.addObject("listeGeeks",geekService.listGeeks());
		return listSpec;
	}
	
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ModelAndView getSpectacle(@PathVariable("id") long id) {
    	ModelAndView listSpec = new ModelAndView("GeekDetail");
    	listSpec.addObject("geek",geekService.getGeek(id));
        return listSpec;
    }
}