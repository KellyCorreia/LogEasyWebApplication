package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Questao;

public interface QuestaoService {
    Iterable<Questao> listAllQuestaos();

    Questao getQuestaoById(Integer id);

    Questao saveQuestao(Questao questao);

    void deleteQuestao(Integer id);
}
