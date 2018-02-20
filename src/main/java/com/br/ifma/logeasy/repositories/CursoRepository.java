package com.br.ifma.logeasy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.ifma.logeasy.domain.Curso;
import com.br.ifma.logeasy.domain.Disciplina;

public interface CursoRepository extends CrudRepository<Curso, Integer>{
	Iterable<Curso> findByDisciplina(Disciplina disciplina);
	Iterable<Curso> findByCodigo(String codigo);
	Iterable<Curso> findByNome(String nome);
}
