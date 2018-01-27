package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Ambiente;
import com.br.ifma.logeasy.repositories.AmbienteRepository;

@Service
public class AmbienteServiceImpl implements AmbienteService {
    private AmbienteRepository ambienteRepository;

    @Autowired
    public void setAmbienteRepository(AmbienteRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    @Override
    public Iterable<Ambiente> listAllAmbientes() {
        return ambienteRepository.findAll();
    }

    @Override
    public Ambiente getAmbienteById(Integer id) {
        return ambienteRepository.findOne(id);
    }

    @Override
    public Ambiente saveAmbiente(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

    @Override
    public void deleteAmbiente(Integer id) {
        ambienteRepository.delete(id);
    }
}
