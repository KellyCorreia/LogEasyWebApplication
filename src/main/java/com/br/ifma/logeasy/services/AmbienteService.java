package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Ambiente;

public interface AmbienteService {
    Iterable<Ambiente> listAllAmbientes();

    Ambiente getAmbienteById(Integer id);

    Ambiente saveAmbiente(Ambiente ambiente);

    void deleteAmbiente(Integer id);
}
