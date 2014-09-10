package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcome(
			@RequestParam(value = "name", defaultValue = "Spring Boot") String name,
			Model model) {
		model.addAttribute("name", name);
		
		return "welcome";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String answer(
			@RequestParam(value = "answer") String answer,
			Model model) {
		model.addAttribute("answer", answer);
		
		return "answer";
	}
}
