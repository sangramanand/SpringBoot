package bootsample.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootsample.model.Task;
import bootsample.service.TaskService;

@RestController
public class SampleRestController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/hello")
	//GetMapping means its a get request
	public String hello(){
		return "Hello World!!!";
	}
	
	@GetMapping("/all-tasks")
	/*
	 * URL - http://localhost:8080/all-tasks
	 */
	public String allTasks(){
		return taskService.findAll().toString();
	}
	
	@GetMapping("/save-task")
	/*
	 * URL - http://localhost:8080/save-task?name=StudyJava&desc=ForExamUpgrade
	 */
	public String saveTask(@RequestParam String name, @RequestParam String desc){
		Task newTask = new Task(name, desc, new Date(), true);
		taskService.save(newTask);
		
		return "task saved!!!";
	}
	
	@GetMapping("/delete-task")
	/*
	 * URL - http://localhost:8080/delete-task?id=4
	 */
	public String deleteTask(@RequestParam Integer id){
		taskService.delete(id);
		
		return "task deleted!!!";
	}
}

