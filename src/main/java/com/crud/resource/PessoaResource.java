package com.crud.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.PessoaDTO;
import com.crud.entities.Pessoa;
import com.crud.service.PessoaService;
import com.crud.util.DTOConverter;

@RestController
@RequestMapping("/crud/v1/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	private DTOConverter<PessoaDTO, Pessoa> mapper = new DTOConverter<PessoaDTO, Pessoa>(PessoaDTO.class, Pessoa.class); 

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	List<PessoaDTO> findAll() {
		return mapper.converterEntityParaDTO(pessoaService.findAll());
    
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	PessoaDTO findByID(@PathVariable("id") Long id) {
		return mapper.converterEntityParaDTO(pessoaService.find(id));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	PessoaDTO save(@RequestBody(required = true) PessoaDTO dto) {
		Pessoa entity = pessoaService.save(mapper.converterDTOParaEntity(dto));
		return mapper.converterEntityParaDTO(entity);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	PessoaDTO update(@PathVariable("id") Long id, @RequestBody(required = true) PessoaDTO dto) {
		Pessoa entity = pessoaService.update(id, mapper.converterDTOParaEntity(dto));
		return mapper.converterEntityParaDTO(entity);
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable("id") Long id) {
		pessoaService.delete(id);
	}

}