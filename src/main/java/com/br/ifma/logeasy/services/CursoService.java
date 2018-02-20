package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Curso;
import com.br.ifma.logeasy.domain.Disciplina;

public interface CursoService {
    Iterable<Curso> listAllCursos();

    Curso getCursoById(Integer id);

    Curso saveCurso(Curso curso);

    void deleteCurso(Integer id);
    
    Iterable<Curso> listCursosByDisciplina(Disciplina disciplina);
    
    Iterable<Curso> listCursosByCodigo(String codigo);
    
    Iterable<Curso> listCursosByNome(String nome);
}
