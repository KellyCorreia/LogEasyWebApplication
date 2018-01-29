package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.CursoAluno;

public interface CursoAlunoService {
    Iterable<CursoAluno> listAllCursoAlunos();

    CursoAluno getCursoAlunoById(Integer id);

    CursoAluno saveCursoAluno(CursoAluno CursoAluno);

    void deleteCursoAluno(Integer id);
}
