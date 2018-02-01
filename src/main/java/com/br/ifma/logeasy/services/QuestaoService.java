package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Questao;

public interface QuestaoService {
    Iterable<Questao> listAllQuestoes();

    Questao getQuestaoById(Integer id);

    Questao saveQuestao(Questao questao);

    void deleteQuestao(Integer id);
}
