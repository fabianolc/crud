package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entities.Pessoa;
import com.crud.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa save(Pessoa p) {
		return repository.save(p);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Pessoa find(Long id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa update(Long id, Pessoa p) {
		return repository.save(p);
	}

}
