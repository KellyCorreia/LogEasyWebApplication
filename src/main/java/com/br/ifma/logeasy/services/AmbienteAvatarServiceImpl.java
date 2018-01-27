package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.AmbienteAvatar;
import com.br.ifma.logeasy.repositories.AmbienteAvatarRepository;

@Service
public class AmbienteAvatarServiceImpl implements AmbienteAvatarService {
    private AmbienteAvatarRepository ambienteAvatarRepository;

    @Autowired
    public void setAmbienteAvatarRepository(AmbienteAvatarRepository ambienteAvatarRepository) {
        this.ambienteAvatarRepository = ambienteAvatarRepository;
    }

    @Override
    public Iterable<AmbienteAvatar> listAllAmbienteAvatars() {
        return ambienteAvatarRepository.findAll();
    }

    @Override
    public AmbienteAvatar getAmbienteAvatarById(Integer id) {
        return ambienteAvatarRepository.findOne(id);
    }

    @Override
    public AmbienteAvatar saveAmbienteAvatar(AmbienteAvatar ambienteAvatar) {
        return ambienteAvatarRepository.save(ambienteAvatar);
    }

    @Override
    public void deleteAmbienteAvatar(Integer id) {
        ambienteAvatarRepository.delete(id);
    }
}
