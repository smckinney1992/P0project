package com.training.jwa.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.jwa.model.Login;

class LoginDAOImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//LoginDAO LoginDAO = new LoginDAOImpl();
		//boolean employee = false;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCheckEmployee() {
		boolean expected = true;
		String input = new String("username");
		assertTrue(expected, new LoginDAOImpl().checkEmployee(input));
	}
	
	private void assertTrue(boolean expected, boolean checkEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void testCheckNotEmployee() {
		boolean expected = false;
		String input = new String("");
		assertTrue(expected, new LoginDAOImpl().checkEmployee(input));
	}

}
