package com.br.ifma.logeasy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.ifma.logeasy.domain.Conteudo;
import com.br.ifma.logeasy.domain.Professor;
import com.br.ifma.logeasy.domain.User;

public interface ConteudoRepository extends CrudRepository<Conteudo, Integer>{
	Iterable<Conteudo> findByProfessor(Professor professor);
}
