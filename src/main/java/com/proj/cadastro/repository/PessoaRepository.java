package com.proj.cadastro.repository;

import com.proj.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Modifying
    @Query("update Pessoa p set p.nome = ?1, p.cpf = ?2, p.dataNascimento = ?3 where p.id = ?4")
    void atualizar(String nome, String cpf, Date dataNascimento, Long id);

}