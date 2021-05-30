package com.proj.cadastro.controller;

import com.proj.cadastro.model.Contato;
import com.proj.cadastro.model.Pessoa;
import com.proj.cadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerenciador")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @GetMapping("/listarPessoas")
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listarPessoas(){
        return cadastroService.findAllPessoas();
    }

    @GetMapping("/listarContatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarContatos(){
        return cadastroService.findAllContatos();
    }

    @GetMapping("/listarPessoa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa listarPorId(@PathVariable Long id){
        return cadastroService.getPessoaById(id);
    }

    @GetMapping("/listarPessoa/{id}/listarContatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato>  listarContatosPorPessoa(@PathVariable Long id){
        return cadastroService.findAllContatosByPessoaId(id);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody Pessoa pessoa) throws Exception {
        cadastroService.cadastrar(pessoa);
    }

    @Transactional
    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@PathVariable("id") long id, @RequestBody Pessoa pessoa) throws Exception {
        cadastroService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        cadastroService.deletarPessoa(id);
    }

}
