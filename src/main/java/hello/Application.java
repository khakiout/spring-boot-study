package hello;

import hello.entity.Task;
import hello.repository.TaskRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		TaskRepository taskRepository = context.getBean(TaskRepository.class);
		
		taskRepository.save(new Task("Task 1", "Task 1 description"));
		taskRepository.save(new Task("Task 2", "Task 2 description"));
		taskRepository.save(new Task("Case", "Task with case title"));
		
		Iterable<Task> tasks = taskRepository.findAll();
		System.out.println("Tasks found with findAll()");
		System.out.println("-------------------------------");
        for (Task task : tasks) {
            System.out.println(task.getTitle() + " - " + task.getId());
        }
        
        Task taskWithTitleCase = taskRepository.findByTitleAllIgnoringCase("case");
        System.out.println("Tasks found with findByTitleAllIgnoringCase()");
		System.out.println("-------------------------------");
        System.out.println(taskWithTitleCase.getTitle() + " - " + taskWithTitleCase.getId());
		
		/*
		System.out.println("Let's inspect the beans provided by Spring Boot.");

		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		*/
	}

}
