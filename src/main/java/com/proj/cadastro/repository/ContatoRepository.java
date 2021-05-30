package com.proj.cadastro.repository;

import com.proj.cadastro.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    void deleteByPessoaId(Long pessoaId);

    List<Contato> findAllByPessoaId(Long id);
}