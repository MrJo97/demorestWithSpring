package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import controller.Alien;
import controller.AlienRepository;


	@RestController
	public class AlienResource 
	{

		AlienRepository repo = new AlienRepository();
		@RequestMapping(value= "aliens", method = RequestMethod.GET,  produces = "application/json")		
		public List<Alien> getAliens()
		{
			return repo.getAliens();
		}
		
		//not working
		@RequestMapping(value= "aliens1", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)		
		public @ResponseBody ModelAndView getAliens1()
		{
			ModelAndView model = new ModelAndView("view1");
			List<Alien> aliens = repo.getAliens();
			model.addObject("aliens", aliens);
			model.setView(new MappingJackson2JsonView());
			return model;
		}
		
	}
