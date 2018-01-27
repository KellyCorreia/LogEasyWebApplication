package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Curso;
import com.br.ifma.logeasy.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
    private CursoRepository cursoRepository;

    @Autowired
    public void setCursoRepository(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Iterable<Curso> listAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoById(Integer id) {
        return cursoRepository.findOne(id);
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Integer id) {
        cursoRepository.delete(id);
    }
}
