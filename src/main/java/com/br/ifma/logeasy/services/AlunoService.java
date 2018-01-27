package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Aluno;

public interface AlunoService {
    Iterable<Aluno> listAllAlunos();

    Aluno getAlunoById(Integer id);

    Aluno saveAluno(Aluno aluno);

    void deleteAluno(Integer id);
}
