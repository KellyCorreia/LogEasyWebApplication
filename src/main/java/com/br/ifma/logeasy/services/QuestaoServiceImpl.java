package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Alternativa;
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
    public Iterable<Questao> listAllQuestoes() {
        return questaoRepository.findAll();
    }

    @Override
    public Questao getQuestaoById(Integer id) {
        return questaoRepository.findOne(id);
    }

    @Override
    public Questao saveQuestao(Questao questao) {
    	Questao questaoSalva;
    	
    	for(Alternativa a : questao.getAlternativas()) {
    		a.setQuestao(questao);
    	}
    	
    	questaoSalva = questaoRepository.save(questao);
    	
        return questaoSalva;
    }

    @Override
    public void deleteQuestao(Integer id) {
    	
        questaoRepository.delete(id);
    }
}
