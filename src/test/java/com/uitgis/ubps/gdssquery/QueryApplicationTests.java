package com.uitgis.ubps.gdssquery;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.uitgis.ubps.gdssquery.domain.Author;
import com.uitgis.ubps.gdssquery.repository.AuthorRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class QueryApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private AuthorRepository authorRepository;
	


	@Before
	public void before() throws Exception {
		authorRepository.save(new Author("Tran Dinh Phong", "Ha Noi", "0900888999", "phonggt@gmail.com"));
		authorRepository.save(new Author("Hoang Dinh Vinh", "HCMC","0900887898", "thaihd@yahoo.com"));
		authorRepository.save(new Author("Do Hoang Kien","Kien Giang","0009878722","kiendh@gmail.com"));
		
		
		
	}

	@Test
	@Ignore
	public void peopleReflectedInRead() throws Exception {
		MediaType halJson = MediaType.parseMediaType("application/hal+json;charset=UTF-8");
		this.mvc.perform(get("/authors")).andExpect(status().isOk()).andExpect(content().contentType(halJson))
				.andExpect(mvcResult -> {
					String contentAsString = mvcResult.getResponse().getContentAsString();
					assertTrue(
							contentAsString.split("totalElements")[1].split(":")[1].trim().split(",")[0].equals("3"));
				});
	}

	@After
	public void after() throws Exception {
		
		authorRepository.delete(authorRepository.findByname("Tran Dinh Phong"));
		authorRepository.delete(authorRepository.findByname("Hoang Dinh Vinh"));
		authorRepository.delete(authorRepository.findByname("Do Hoang Kien"));
		
		
		
	}
}
