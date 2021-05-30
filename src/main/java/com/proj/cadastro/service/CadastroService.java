package com.proj.cadastro.service;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;
import com.proj.cadastro.model.Contato;
import com.proj.cadastro.model.Pessoa;
import com.proj.cadastro.repository.ContatoRepository;
import com.proj.cadastro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CadastroService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    public Pessoa cadastrar(Pessoa pessoa) throws Exception {
        validaCPF(pessoa.getCpf());
        pessoa.setCpf(formataCPF(pessoa.getCpf()));
        int value = pessoa.getContatos().size();
        for (int i = 0 ; i < value; i++) {
            Contato novoContato = pessoa.getContatos().get(i);
            validaEmail(novoContato.getEmail());
            addContato(pessoa, novoContato);
        }
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public List<Pessoa> findAllPessoas(){
        return pessoaRepository.findAll();
    }

    public List<Contato> findAllContatos(){
        return contatoRepository.findAll();
    }

    public void atualizarPessoa(Long id, Pessoa pessoa) throws Exception {
        Pessoa dados = pessoaRepository.getById(id);
        validaCPF(pessoa.getCpf());
        validaDataNascimento(pessoa.getDataNascimento());
        pessoa.setCpf(formataCPF(pessoa.getCpf()));
        dados.setNome(pessoa.getNome());
        dados.setCpf(pessoa.getCpf());
        dados.setDataNascimento(pessoa.getDataNascimento());
        dados.setContatos(pessoa.getContatos());
        pessoaRepository.save(dados);
    }

    private void validaDataNascimento(Date dataNascimento) {
    }

    public Pessoa getPessoaById(Long id) {
        return pessoaRepository.getById(id);
    }

    public List<Contato> findAllContatosByPessoaId(Long id) {
        return contatoRepository.findAllByPessoaId(id);
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
        contatoRepository.deleteByPessoaId(id);
    }

    public void addContato(Pessoa p, Contato contatoNovo){
        contatoNovo.setPessoa(p);
        p.getContatos().add(contatoNovo);
    }

    public void validaCPF(String cpf) throws Exception {
        try{
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(cpf);
        } catch (Exception e) {
            throw new Exception("CPF inválido!");
        }
    }

    public String formataCPF(String cpf) {
        CPFFormatter cpfFormatter = new CPFFormatter();
        if (!cpfFormatter.isFormatted(cpf))
            return cpfFormatter.format(cpf);
        return cpf;
    }

    public void validaEmail(String email) throws Exception {
        Matcher matcher = Pattern.compile("^(.+)@(\\S+)$").matcher(email);
        if(!matcher.matches())
            throw new Exception("Email inválido!");
    }

}
