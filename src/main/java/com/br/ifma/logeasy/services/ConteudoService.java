package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Conteudo;

public interface ConteudoService {
    Iterable<Conteudo> listAllConteudos();

    Conteudo getConteudoById(Integer id);

    Conteudo saveConteudo(Conteudo conteudo);

    void deleteConteudo(Integer id);
}
