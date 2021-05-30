package com.proj.cadastro.model;

import org.assertj.core.util.DateUtil;

public class EnvPessoa {

    public static Pessoa novaPessoa(){
        Pessoa p = new Pessoa();
        p.setId(1L);
        p.setNome("Nome");
        p.setCpf("767.794.490-67");
        p.setDataNascimento(DateUtil.yesterday());
        p.getContatos().add(EnvContato.novoContato());
        return p;
    }

    public static Pessoa novaPessoaDataFutura(){
        Pessoa p = new Pessoa();
        p.setId(1L);
        p.setNome("Nome");
        p.setCpf("767.794.490-67");
        p.setDataNascimento(DateUtil.tomorrow());
        p.getContatos().add(EnvContato.novoContato());
        return p;
    }

    public static Pessoa novaPessoaSemContato(){
        Pessoa p = new Pessoa();
        p.setId(1L);
        p.setNome("Nome");
        p.setCpf("767.794.490-67");
        p.setDataNascimento(DateUtil.yesterday());
        return p;
    }
}
