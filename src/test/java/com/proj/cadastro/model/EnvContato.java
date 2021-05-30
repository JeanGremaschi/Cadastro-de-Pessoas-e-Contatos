package com.proj.cadastro.model;

public class EnvContato {

    public static Contato novoContato(){
        Contato c = new Contato();
        c.setId(1L);
        c.setNome("Nome");
        c.setTelefone("44 99889988");
        c.setEmail("email@email.com");
        c.setPessoa(EnvPessoa.novaPessoa());
        return c;
    }

}
