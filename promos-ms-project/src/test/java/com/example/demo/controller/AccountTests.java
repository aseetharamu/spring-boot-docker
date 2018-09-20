package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.repository.AccountRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountTests {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
    private AccountRepository repo;
	
	@Test
	public void getAccoutntTest() throws Exception{
		this.mvc.perform(get("/api/accounts").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().isOk());
        //.andExpect(content().string("The Account id is : 104"));
		
	}
	

}
