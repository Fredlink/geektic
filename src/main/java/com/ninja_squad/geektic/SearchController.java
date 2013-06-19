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
		TypeInteret[] namedConstantsLangs = TypeInteret.valuesLanguages();
		search.addObject("listeInteretsLangs",namedConstantsLangs);
		TypeInteret[] namedConstantsJv = TypeInteret.valuesJv();
		search.addObject("listeInteretsJv",namedConstantsJv);
		return search;
	}
	
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getSpectacle(
    		@RequestParam("interest") String interest,
    		@RequestParam("name") String nom,
    		@RequestParam("btnSearch") String typeSearch) {
    	ModelAndView listSpec = new ModelAndView("Geeks");
    	if(typeSearch.equals("Rechercher par nom")){
	    	List<Geek> ge = geekService.find(nom);
			for(Geek geek : ge){
				System.out.println(geek.getNom());
			}
	    	listSpec.addObject("listeGeeks",geekService.find(nom));
	    	listSpec.addObject("nameSearch","true");
    	}
    	if(typeSearch.equals("Rechercher par intérêt")){
	    	List<Geek> ge = geekService.find(TypeInteret.valueOf(interest));
			for(Geek geek : ge){
				System.out.println(geek.getNom());
			}
	    	listSpec.addObject("listeGeeks",geekService.find(TypeInteret.valueOf(interest)));
	    	listSpec.addObject("interet",interest);
    	}
        return listSpec;
    }
}

