package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Conteudo;
import com.br.ifma.logeasy.domain.Professor;
import com.br.ifma.logeasy.repositories.ConteudoRepository;

@Service
public class ConteudoServiceImpl implements ConteudoService {
    private ConteudoRepository conteudoRepository;

    @Autowired
    public void setConteudoRepository(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    @Override
    public Iterable<Conteudo> listAllConteudos() {
        return conteudoRepository.findAll();
    }

    @Override
    public Conteudo getConteudoById(Integer id) {
        return conteudoRepository.findOne(id);
    }

    @Override
    public Conteudo saveConteudo(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    @Override
    public void deleteConteudo(Integer id) {
        conteudoRepository.delete(id);
    }

	@Override
	public Iterable<Conteudo> listConteudosByProfessor(Professor professor) {
		return conteudoRepository.findByProfessor(professor);
	}
    
}
