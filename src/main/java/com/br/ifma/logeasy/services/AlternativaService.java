package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Alternativa;
import com.br.ifma.logeasy.domain.Questao;

public interface AlternativaService {
    Iterable<Alternativa> listAllAlternativas();
    
    Iterable<Alternativa> listAlternativasByQuestao(Questao questao);
    
    Alternativa getAlternativaById(Integer id);

    Alternativa saveAlternativa(Alternativa alternativa);

    void deleteAlternativa(Integer id);
}
