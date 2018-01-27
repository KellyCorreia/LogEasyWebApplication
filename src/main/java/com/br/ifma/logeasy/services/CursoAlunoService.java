package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Curso;

public interface CursoAlunoService {
    Iterable<Curso> listAllCursos();

    Curso getCursoById(Integer id);

    Curso saveCurso(Curso curso);

    void deleteCurso(Integer id);
}
