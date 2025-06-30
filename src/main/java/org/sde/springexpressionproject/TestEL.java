package org.sde.springexpressionproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;

//import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.sde.springexpressionproject.service.EnrichObject;

import org.sde.springexpressionproject.service.InjectedService;
import org.sde.springexpressionproject.service.ObRequest;

@SpringBootApplication
public class TestEL {

//	@Value("#{1 eq 1}") // style SpEL 
	
	
//	@Resource(name="injectedService")
	private InjectedService service;
	
	public TestEL() {}
	
	public static void main(String[] args) {
		SpringApplication.run(TestEL.class, args);
		System.out.println("testing 123");

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			
			ObRequest request = new ObRequest();
			request.setAddr("addr xxxx");
			request.setAmount("11111");
			request.setName("name yyyyy");
			
			EnrichObject enrich = new EnrichObject();
			enrich.setMobilePri("111111111111");
			enrich.setMobileSec("2222222222");
			
			service.setEnrich(enrich);
			service.setInput(request);
			
			System.out.println("====> " + service.getEnrich().getMobilePri());
			
			StandardEvaluationContext simpleContext = new StandardEvaluationContext(service);
			ExpressionParser parser = new SpelExpressionParser();
			Expression exp = parser.parseExpression("input.addr");
			System.out.println("addr===>" + exp.getValue(simpleContext));

			exp = parser.parseExpression("multiply(3)");
			System.out.println("multiply===>" + exp.getValue(simpleContext));
			
			exp = parser.parseExpression("multiply3(3)");
			System.out.println("multiply2===>" + exp.getValue(simpleContext));

		};
	}

	public InjectedService getService() {
		return service;
	}

	public void setService(InjectedService service) {
		this.service = service;
	}
	
	
}
