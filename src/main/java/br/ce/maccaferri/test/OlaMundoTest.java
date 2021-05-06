package br.ce.maccaferri.test;

import org.junit.Assert;
import org.junit.Test;


import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;

public class OlaMundoTest {

	@Test
	public void testOlaMUndo() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");

		// criou um objeto response que est� recebendo essa requisição
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
		Assert.assertTrue(response.statusCode() == 200);
		Assert.assertTrue("O status code deveria ser 200", response.statusCode() == 200);

		Assert.assertEquals(201, response.statusCode());
		// valor esperado e atual = assert equals
		

		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);

	}

	@Test
	public void segundoMetodoRestAssured() {
//		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
//		ValidatableResponse validacao = response.then(); // validacao é objeto
//		validacao.statusCode(200);
		
		//get("http://restapi.wcaquino.me/ola").then().statusCode(200);
		
		given()// pre-consição		
		.when() // ação de fato
			.get("http://restapi.wcaquino.me/ola")		
		.then()
			.assertThat()	
			.statusCode(200); //assertivas
	}

}