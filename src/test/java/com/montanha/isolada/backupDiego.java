package com.montanha.isolada;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import io.restassured.http.ContentType;

public class backupDiego {

    //    //login v1 - imprimindo tudo
    //        given()
//                .contentType(ContentType.JSON)
//                .body("{\n" +
//                    "  \"email\": \"admin@email.com\",\n" +
//                    "  \"senha\": \"654321\"\n" +
//                    "}")
//        .when()
//            .post("/v1/auth")
//        .then()
//                .log()
//                .all();



    //    //cadastrar Viagem v1 - imprimindo tudo
//    given()
//                .contentType(ContentType.JSON)
//                .body("{\n" +
//                              "  \"acompanhante\": \"ana\",\n" +
//                              "  \"dataPartida\": \"2020-05-02\",\n" +
//                              "  \"dataRetorno\": \"2020-10-02\",\n" +
//                              "  \"localDeDestino\": \"Paraiba\",\n" +
//                              "  \"regiao\": \"Norte\"\n" +
//                              "}")
//                .header("Authorization" , token)
//        .when()
//                .post("/v1/viagens")
//        .then()
//                .log()
//                    .all();




//    //cadastrar Viagem v2 - assert
//    given()
//                .contentType(ContentType.JSON)
//                .body("{\n" +
//                              "  \"acompanhante\": \"diego\",\n" +
//                              "  \"dataPartida\": \"2020-05-02\",\n" +
//                              "  \"dataRetorno\": \"2020-10-02\",\n" +
//                              "  \"localDeDestino\": \"Paraiba\",\n" +
//                              "  \"regiao\": \"Norte\"\n" +
//                              "}")
//                .header("Authorization" , token)
//        .when()
//                .post("/v1/viagens")
//        .then()
//                .assertThat()
//                    .statusCode(201)
//                    .body("data.localDeDestino", equalTo("Paraiba"))
//            .body("data.acompanhante", equalToIgnoringCase("DIEGO"));

	@Test
	public void testePadraoItens() {
		given()
		.when()
			.delete("/contas/{id}")
		.then()
			.statusCode(500)
		.body("constraint", is("transacoes_conta_id_foreign"));
	}
	
}
