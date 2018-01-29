package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Nivel;

public interface NivelService {
    Iterable<Nivel> listAllNiveis();

    Nivel getNivelById(Integer id);

    Nivel saveNivel(Nivel nivel);

    void deleteNivel(Integer id);
}
