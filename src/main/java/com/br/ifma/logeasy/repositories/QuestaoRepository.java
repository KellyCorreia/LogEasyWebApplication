package com.br.ifma.logeasy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.br.ifma.logeasy.domain.Conteudo;
import com.br.ifma.logeasy.domain.Professor;
import com.br.ifma.logeasy.domain.Questao;

public interface QuestaoRepository extends CrudRepository<Questao, Integer>{
}
