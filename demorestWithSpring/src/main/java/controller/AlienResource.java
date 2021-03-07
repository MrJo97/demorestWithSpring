package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		public @ResponseBody ModelAndView getAliens1(@RequestParam String button, HttpServletRequest request)
		{
			System.out.println(button);
			
				
			ModelAndView model = new ModelAndView("view1");
			List<Alien> aliens = repo.getAliens();
			model.addObject("aliens", aliens);
			
			HttpSession session = request.getSession();
			
			
			if(session.getAttribute("pageNumber")==null)
				session.setAttribute("pageNumber", 1);
			else
			{
				//questi vengono eseguiti solo se clicco su next o prev
				int pageNumber = (Integer) session.getAttribute("pageNumber");
				if(button.equals("next") && pageNumber*4<aliens.size()) //*4 perchè voglio mostrare 4 elementi di lista ad ogni pagina
					session.setAttribute("pageNumber", pageNumber+1);
				if(button.equals("prev") && pageNumber != 1)
					session.setAttribute("pageNumber", pageNumber-1);
			}
			
			//domanda: il valore che indica il numero della pagina, è meglio memorizzarlo nella session o scambiarlo 
			//sempre in formato JSON? eh ma il jSON non va bene...meglio la session. 
			model.addObject("pageNumber", session.getAttribute("pageNumber"));
			model.setView(new MappingJackson2JsonView());
			return model;
		}
		
	}
