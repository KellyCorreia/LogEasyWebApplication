package com.br.ifma.logeasy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.ifma.logeasy.domain.Alternativa;
import com.br.ifma.logeasy.domain.Questao;

public interface AlternativaRepository extends CrudRepository<Alternativa, Integer>{
	Iterable<Alternativa> findByQuestao(Questao questao);
}
