package dev.cuny.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import dev.cuny.repositories.ClientRepository;

@SpringBootTest
@ContextConfiguration(classes=dev.cuny.app.BbsApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BbsApplicationTests {
	@Autowired
	ClientRepository cr;
	@Test
	@Order(1)
	void getClientbyId() {
		Assertions.assertTrue(cr.findById(1) != null);
	}
	
	@Test
	@Order(2)
	void getClientByUsername() {
		Assertions.assertTrue(cr.findByUsername("theRaidMan") != null);
		
	}
	
	@Test
	@Order(3)
	void getClientByUsernameAndPassword() {
		String username = "theRaidMan";
		String password = "password";

		Assertions.assertTrue(cr.findByUsernameAndPassword(username, password) != null);
	}

}
