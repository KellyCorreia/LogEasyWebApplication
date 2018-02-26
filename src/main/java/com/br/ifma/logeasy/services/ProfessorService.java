package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Professor;

public interface ProfessorService {
    Iterable<Professor> listAllProfessors();
    
    Professor findByUsername(String username);

    Professor getProfessorById(Integer id);

    Professor saveProfessor(Professor professor);

    void deleteProfessor(Integer id);
}
