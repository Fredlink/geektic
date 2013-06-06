package com.ninja_squad.geektic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	GeekService geekService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView search = new ModelAndView("recherche");
		TypeInteret[] namedConstants = TypeInteret.values();
		search.addObject("listeInterets",namedConstants);
		return search;
	}
	
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getSpectacle(@RequestParam("interest") String interest) {
    	ModelAndView listSpec = new ModelAndView("Geeks");
    	List<Geek> ge = geekService.find(TypeInteret.valueOf(interest));
		for(Geek geek : ge){
			System.out.println(geek.getNom());
		}
    	listSpec.addObject("listeGeeks",geekService.find(TypeInteret.valueOf(interest)));
    	listSpec.addObject("interet",interest);
        return listSpec;
    }
}

