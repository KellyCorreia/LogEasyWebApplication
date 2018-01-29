package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.CursoAluno;
import com.br.ifma.logeasy.repositories.CursoAlunoRepository;

@Service
public class CursoAlunoServiceImpl implements CursoAlunoService {
    private CursoAlunoRepository cursoAlunoRepository;

    @Autowired
    public void setCursoAlunoRepository(CursoAlunoRepository cursoAlunoRepository) {
        this.cursoAlunoRepository = cursoAlunoRepository;
    }

    @Override
    public Iterable<CursoAluno> listAllCursoAlunos() {
        return cursoAlunoRepository.findAll();
    }

    @Override
    public CursoAluno getCursoAlunoById(Integer id) {
        return cursoAlunoRepository.findOne(id);
    }

    @Override
    public CursoAluno saveCursoAluno(CursoAluno cursoAluno) {
        return cursoAlunoRepository.save(cursoAluno);
    }

    @Override
    public void deleteCursoAluno(Integer id) {
        cursoAlunoRepository.delete(id);
    }
}
