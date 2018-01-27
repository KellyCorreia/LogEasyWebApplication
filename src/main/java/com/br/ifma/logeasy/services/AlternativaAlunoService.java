package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.AlternativaAluno;

public interface AlternativaAlunoService {
    Iterable<AlternativaAluno> listAllAlternativaAlunos();

    AlternativaAluno getAlternativaAlunoById(Integer id);

    AlternativaAluno saveAlternativaAluno(AlternativaAluno product);

    void deleteAlternativaAluno(Integer id);
}
