package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.AmbienteAvatar;

public interface AmbienteAvatarService {
    Iterable<AmbienteAvatar> listAllAmbienteAvatars();

    AmbienteAvatar getAmbienteAvatarById(Integer id);

    AmbienteAvatar saveAmbienteAvatar(AmbienteAvatar product);

    void deleteAmbienteAvatar(Integer id);
}
