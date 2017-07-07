package bootsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import bootsample.service.TaskService;

@Controller
public class MainController {
	
	@Autowired
	private TaskService TaskService;
	
	
	@GetMapping("/")
	public String home(){
		return "index";
	}
}
