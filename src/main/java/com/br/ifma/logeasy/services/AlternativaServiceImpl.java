package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Alternativa;
import com.br.ifma.logeasy.domain.Questao;
import com.br.ifma.logeasy.repositories.AlternativaRepository;

@Service
public class AlternativaServiceImpl implements AlternativaService {
    private AlternativaRepository alternativaRepository;

    @Autowired
    public void setAlternativaRepository(AlternativaRepository alternativaRepository) {
        this.alternativaRepository = alternativaRepository;
    }

    @Override
    public Iterable<Alternativa> listAllAlternativas() {
        return alternativaRepository.findAll();
    }

    @Override
    public Alternativa getAlternativaById(Integer id) {
        return alternativaRepository.findOne(id);
    }

    @Override
    public Alternativa saveAlternativa(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    @Override
    public void deleteAlternativa(Integer id) {
        alternativaRepository.delete(id);
    }

	@Override
	public Iterable<Alternativa> listAlternativasByQuestao(Questao questao) {
		return alternativaRepository.findByQuestao(questao);
	}
}
