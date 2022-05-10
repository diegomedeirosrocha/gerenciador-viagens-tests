package com.montanha.isolada;

import com.montanha.factory.UsuarioDataFactory;
import com.montanha.factory.ViagemDataFactory;
import com.montanha.pojo.Usuario;
import com.montanha.pojo.Viagem;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class ViagensTest {

    @Before
    public void setUp(){
    }

    @Test
    public void testeCadastroViagemValidaRetornaSucesso(){
        baseURI = "http://localhost";
        port = 8089;
        basePath = "/api";

        Usuario usuarioAdminstrador = new UsuarioDataFactory().criarUsuarioAdminstrador();

        //login admin
        String tokenAdmin = given()
                .contentType(ContentType.JSON)
                .body(usuarioAdminstrador)
            .when()
                .post("/v1/auth")
            .then()
                .extract()
                    .path("data.token");
        System.out.println("token admin {} " + tokenAdmin);

        
        Viagem viagemValida = new ViagemDataFactory().criarViagemValidaSul();

        //cadastrar Viagem
        given()
                .contentType(ContentType.JSON)
                .body(viagemValida)
                .header("Authorization" , tokenAdmin)
        .when()
                .post("/v1/viagens")
        .then()
                .assertThat()
                    .statusCode(201)
                    .body("data.localDeDestino", equalTo("Paraiba"))
                    .body("data.acompanhante", equalToIgnoringCase("DIEGO"));
    }

    @Test
    public void testeCadastroViagemValidaContrato(){
        baseURI = "http://localhost";
        port = 8089;
        basePath = "/api";

        Usuario usuarioAdminstrador = new UsuarioDataFactory().criarUsuarioAdminstrador();

        //login admin
        String tokenAdmin = given()
                .contentType(ContentType.JSON)
                .body(usuarioAdminstrador)
            .when()
                .post("/v1/auth")
            .then()
                .extract()
                    .path("data.token");
        System.out.println("token admin {} " + tokenAdmin);


        Viagem viagemValida = new ViagemDataFactory().criarViagemValidaSul();



        //cadastrar Viagem
        given()
                .contentType(ContentType.JSON)
                .body(viagemValida)
                .header("Authorization" , tokenAdmin)
        .when()
            .post("/v1/viagens")
        .then()
            .assertThat()
               .statusCode(201)
                .body(matchesJsonSchemaInClasspath("schemas/postV1ViagensViagemValida.json"));
        //site contrato = https://jsonschema.net/home
    }

    @Test
    public void testeRetornoViagemPossuiStatusCode200MostraLocalDestino() {
    	
        Usuario usuarioComum = new UsuarioDataFactory().criarUsuarioComum();
        
        //login usuario comum
        String tokenUsuario = given()
                .contentType(ContentType.JSON)
                .body(usuarioComum)
            .when()
                .post("/v1/auth")
            .then()
                .extract()
                	.path("data.token");
        System.out.println("token usuario {} " + tokenUsuario);
        
        //cadastrar Viagem
        given()
                .header("Authorization" , tokenUsuario)
        .when()
                .get("/v1/viagens/1")
        .then()
                .assertThat()
                    .statusCode(200)
                	.body("data.localDeDestino", equalTo("Paraiba"));
        
    }
    
}
