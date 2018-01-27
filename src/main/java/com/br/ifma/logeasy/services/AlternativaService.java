package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Alternativa;

public interface AlternativaService {
    Iterable<Alternativa> listAllAlternativas();

    Alternativa getAlternativaById(Integer id);

    Alternativa saveAlternativa(Alternativa alternativa);

    void deleteAlternativa(Integer id);
}
