package com.proj.cadastro.controller;

import com.proj.cadastro.model.EnvPessoa;
import com.proj.cadastro.repository.ContatoRepository;
import com.proj.cadastro.repository.PessoaRepository;
import com.proj.cadastro.service.CadastroService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;


@WebMvcTest
public class CadastroControllerTest {

    @Autowired
    CadastroController cadastroController;

    @Mock
    PessoaRepository pessoaRepository;

    @Mock
    ContatoRepository contatoRepository;

    @MockBean
    private CadastroService cadastroService;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @After
    public void after() throws Exception {
    }

    //fixme Enviroments causando stackoverflow por conta da referência mútua
    @Test
    @Disabled
    public void shouldCreatePessoa() throws Exception {
        RestAssuredMockMvc.standaloneSetup(this.cadastroController);
        when(this.cadastroService.cadastrar(new EnvPessoa().novaPessoa())).thenReturn(new EnvPessoa().novaPessoa());
        given().accept(ContentType.JSON).when().post("/cadastrar").then().statusCode(HttpStatus.CREATED.value());
    }

    @Test
    @Disabled
    public void shouldReturnPessoa(){
        RestAssuredMockMvc.standaloneSetup(this.cadastroController);
        given().accept(ContentType.JSON).when().get("/listarPessoa/{id}", 1L).then().statusCode(HttpStatus.OK.value());
    }

}
