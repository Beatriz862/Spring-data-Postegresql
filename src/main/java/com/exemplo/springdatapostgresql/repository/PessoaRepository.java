package com.exemplo.springdatapostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.springdatapostgresql.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}