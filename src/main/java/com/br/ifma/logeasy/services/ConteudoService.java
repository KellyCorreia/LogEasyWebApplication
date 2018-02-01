package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Conteudo;
import com.br.ifma.logeasy.domain.Professor;

public interface ConteudoService {
    Iterable<Conteudo> listAllConteudos();
    
    Iterable<Conteudo> listConteudosByProfessor(Professor professor);

    Conteudo getConteudoById(Integer id);

    Conteudo saveConteudo(Conteudo conteudo);

    void deleteConteudo(Integer id);
}
