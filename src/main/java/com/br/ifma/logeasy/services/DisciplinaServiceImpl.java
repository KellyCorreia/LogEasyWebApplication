package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Disciplina;
import com.br.ifma.logeasy.repositories.DisciplinaRepository;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public Iterable<Disciplina> listAllDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Disciplina getDisciplinaById(Integer id) {
        return disciplinaRepository.findOne(id);
    }

    @Override
    public Disciplina saveDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public void deleteDisciplina(Integer id) {
        disciplinaRepository.delete(id);
    }
}
