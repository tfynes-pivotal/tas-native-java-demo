package io.paketo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		String instanceId = System.getenv("CF_INSTANCE_INDEX");
		String s = "hi there: from instance " + instanceId + "\n";
		System.out.println(s);
		return s;
	}

}
