package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Disciplina;

public interface DisciplinaService {
    Iterable<Disciplina> listAllDisciplinas();

    Disciplina getDisciplinaById(Integer id);

    Disciplina saveDisciplina(Disciplina disciplina);

    void deleteDisciplina(Integer id);
}
