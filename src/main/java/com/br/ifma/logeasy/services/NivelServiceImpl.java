package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Nivel;
import com.br.ifma.logeasy.repositories.NivelRepository;

@Service
public class NivelServiceImpl implements NivelService {
    private NivelRepository nivelRepository;

    @Autowired
    public void setNivelRepository(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    @Override
    public Iterable<Nivel> listAllNiveis() {
        return nivelRepository.findAll();
    }

    @Override
    public Nivel getNivelById(Integer id) {
        return nivelRepository.findOne(id);
    }

    @Override
    public Nivel saveNivel(Nivel nivel) {
        return nivelRepository.save(nivel);
    }

    @Override
    public void deleteNivel(Integer id) {
        nivelRepository.delete(id);
    }
}
