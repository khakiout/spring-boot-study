package hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${app.name}")
	public String appName;
	
	@RequestMapping("/")
	public String index() {
		System.out.println(appName);
		return "Hello World!";
	}
}
