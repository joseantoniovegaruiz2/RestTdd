package com.galvanize.RestSpring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class RestSpringApplicationIT {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void addAnimal() throws Exception {
		AnimalDto animalDto = new AnimalDto(new Animal("Bear", AnimalType.WALKING));

		this.mockMvc.perform(MockMvcRequestBuilders.post("/animals")
				.content(this.objectMapper.writeValueAsString(animalDto))
				.contentType(MediaType.APPLICATION_JSON)
		);

		this.mockMvc.perform(MockMvcRequestBuilders.get("/animals"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("[0].name").value("Bear"))
				.andExpect(MockMvcResultMatchers.jsonPath("[0].animalType").value("WALKING"))
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
	}
}
