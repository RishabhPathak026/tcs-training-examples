package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation takes care auto-configuration based on the libraries
// e.g.: If your project has spring boot starter web - the @SpringBootApplication does
// component scanning from the package it is present & also all of its sub-packages
// auto-configures the application based on the library - 
// providing server, configuring web components, configuring database dependencies
@SpringBootApplication
public class SpringBootDemoApplication  {

	public static void main(String[] args) {
		// it launches the spring application and performs all the auto-configuration
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	/*
	 * Earlier you initialized ApplicationContext to get all the beans, but in spring boot
	 * it already available you can get through Command Line Runner if you are using Console based,
	 * and If you are using Web/Rest based application you can get all the beans without 
	 * ApplicationContext
	 */
	// this method will be automatically executed with @Bean
	// @Bean would create the bean instance & maintains it in the spring container
//	@Bean
//	public CommandLineRunner runner(ApplicationContext ctx) {
//		return (args) -> { 
//			HelloService service = (HelloService)ctx.getBean("helloService");
//			System.out.println(service.greetings());
//		};
//	}
	// the above code is similar to ApplicationContext ctx = new ClasspathXmlApplicationContext(xmlfile);
	// HelloService service = (HelloService)ctx.getBean("helloService")
	
}
