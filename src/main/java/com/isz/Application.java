package com.isz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.client.RestTemplate;

import com.isz.model.UserModel;
import com.isz.repository.UserModelRepository;



@SpringBootApplication
@Configuration
@EnableAutoConfiguration 
public class Application implements CommandLineRunner {

	  
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public UserModelRepository userModelRepository;

	@Bean
	public Converter<String, UserModel> userConverter() {
		return new Converter<String, UserModel>() {
			@Override
			public UserModel convert(String id) {
				return userModelRepository.findOne(Long.valueOf(id));
			}
		};
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		 new RestTemplate();  
//		 template.getForObject("http://localhost:8080/api/good?page=1&size=10", GoodModel.class);  
		
	}

}
