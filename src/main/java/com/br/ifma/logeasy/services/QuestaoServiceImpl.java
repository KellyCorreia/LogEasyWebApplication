package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Alternativa;
import com.br.ifma.logeasy.domain.Questao;
import com.br.ifma.logeasy.repositories.QuestaoRepository;

@Service
public class QuestaoServiceImpl implements QuestaoService {
    private QuestaoRepository questaoRepository;
    private AlternativaService alternativaService;

    @Autowired
    public void setQuestaoRepository(QuestaoRepository questaoRepository) {
        this.questaoRepository = questaoRepository;
    }
    
    @Autowired
    public void setAlternativaService(AlternativaService alternativaService) {
        this.alternativaService = alternativaService;
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
    	questaoSalva = questaoRepository.save(questao);
    	if(questao.getAlternativas()!=null) {
    		for(Alternativa alt: questao.getAlternativas()) {
        		alt.setQuestao(questaoSalva);
        		alternativaService.saveAlternativa(alt);
        	}
    	}
        return questao;
    }

    @Override
    public void deleteQuestao(Integer id) {
        questaoRepository.delete(id);
    }
}
