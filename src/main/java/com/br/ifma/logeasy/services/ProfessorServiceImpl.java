package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Professor;
import com.br.ifma.logeasy.repositories.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;

    @Autowired
    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Iterable<Professor> listAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Integer id) {
        return professorRepository.findOne(id);
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteProfessor(Integer id) {
        professorRepository.delete(id);
    }
}
