package com.exemplo.springdatapostgresql.controller;

import com.exemplo.springdatapostgresql.model.Pessoa;
import com.exemplo.springdatapostgresql.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    
    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public Optional<Pessoa> buscarPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id);
    }

    
    @PostMapping
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    @PutMapping("/{id}")
    public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setIdade(pessoaAtualizada.getIdade());
            return pessoaRepository.save(pessoa);
        }).orElseGet(() -> {
            pessoaAtualizada.setId(id);
            return pessoaRepository.save(pessoaAtualizada);
        });
    }

    
    @DeleteMapping("/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}