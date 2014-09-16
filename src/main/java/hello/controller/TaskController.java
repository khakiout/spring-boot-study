package hello.controller;

import hello.entity.Task;
import hello.repository.TaskRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/task")
public class TaskController {
	private static final Logger log = LoggerFactory.getLogger(TaskController.class.getName());
	
	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Long id,  Model model) {
		Task task = taskRepository.findOne(id);
		
		if (task != null) {
			log.info("Task is found: {}", task.getTitle());
			model.addAttribute("task", task);
		} else {
			log.warn("Task with ID {} is not found.", id);
		}
		
		return "task/view";
	}
	
	// TODO
	@RequestMapping(method=RequestMethod.GET)
	public String newTask() {
		
		return "task/new";
	}
	
	// TODO
	@RequestMapping(method=RequestMethod.POST)
	public String saveTask() {
		
		if (false) {
			return "task/new";
		}
		
		return "task/view";
	}
}
