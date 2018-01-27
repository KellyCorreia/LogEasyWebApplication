package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Questao;
import com.br.ifma.logeasy.repositories.QuestaoRepository;

@Service
public class QuestaoServiceImpl implements QuestaoService {
    private QuestaoRepository questaoRepository;

    @Autowired
    public void setQuestaoRepository(QuestaoRepository questaoRepository) {
        this.questaoRepository = questaoRepository;
    }

    @Override
    public Iterable<Questao> listAllQuestaos() {
        return questaoRepository.findAll();
    }

    @Override
    public Questao getQuestaoById(Integer id) {
        return questaoRepository.findOne(id);
    }

    @Override
    public Questao saveQuestao(Questao questao) {
        return questaoRepository.save(questao);
    }

    @Override
    public void deleteQuestao(Integer id) {
        questaoRepository.delete(id);
    }
}
