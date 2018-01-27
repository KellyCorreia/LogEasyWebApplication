package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.AlternativaAluno;
import com.br.ifma.logeasy.repositories.AlternativaAlunoRepository;

@Service
public class AlternativaAlunoServiceImpl implements AlternativaAlunoService {
    private AlternativaAlunoRepository alternativaalunoRepository;

    @Autowired
    public void setAlternativaAlunoRepository(AlternativaAlunoRepository alternativaalunoRepository) {
        this.alternativaalunoRepository = alternativaalunoRepository;
    }

    @Override
    public Iterable<AlternativaAluno> listAllAlternativaAlunos() {
        return alternativaalunoRepository.findAll();
    }

    @Override
    public AlternativaAluno getAlternativaAlunoById(Integer id) {
        return alternativaalunoRepository.findOne(id);
    }

    @Override
    public AlternativaAluno saveAlternativaAluno(AlternativaAluno alternativaaluno) {
        return alternativaalunoRepository.save(alternativaaluno);
    }

    @Override
    public void deleteAlternativaAluno(Integer id) {
        alternativaalunoRepository.delete(id);
    }
}
