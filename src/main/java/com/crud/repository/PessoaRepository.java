package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
