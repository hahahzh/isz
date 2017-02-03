package com.isz;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.isz.model.UserModel;
import com.isz.repository.UserDetailModelRepository;
import com.isz.repository.UserModelRepository;

@RunWith(SpringRunner.class) 
@SpringApplicationConfiguration(classes = ApplicationTests.class)
@WebAppConfiguration 
@Configuration
public class ApplicationTests{

	private TestRestTemplate template = new TestRestTemplate();

//	@Autowired(required=true)
//	private UserDetailModelRepository userDetailModelRepository;

	@Autowired(required=true)
	private UserModelRepository userModelRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD HH/mm:ss");
	
	@Test
	@Rollback(true)
	public void testFindByUser() {
//		UserDetailModel ud = this.userDetailModelRepository.findOne(10L);
		UserModel ud = this.userModelRepository.findOne(11L);
		assertEquals(10+"", ud.getId()+"");
		
	}



}
