package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Professor;
import com.br.ifma.logeasy.domain.User;
import com.br.ifma.logeasy.repositories.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;
    private UserService userService;

    @Autowired
    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
    	professor.setUsuario(
    			userService.criptografaSenha(professor.getUsuario()));
        return professorRepository.save(professor);
    }

    @Override
    public void deleteProfessor(Integer id) {
        professorRepository.delete(id);
    }

	@Override
	public Professor findByUsername(String username) {
		User user = userService.findByUsername(username);
		return user.getProfessor();
	}
}
