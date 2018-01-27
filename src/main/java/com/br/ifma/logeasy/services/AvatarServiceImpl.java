package com.br.ifma.logeasy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ifma.logeasy.domain.Avatar;
import com.br.ifma.logeasy.repositories.AvatarRepository;

@Service
public class AvatarServiceImpl implements AvatarService {
    private AvatarRepository avatarRepository;

    @Autowired
    public void setAvatarRepository(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    @Override
    public Iterable<Avatar> listAllAvatars() {
        return avatarRepository.findAll();
    }

    @Override
    public Avatar getAvatarById(Integer id) {
        return avatarRepository.findOne(id);
    }

    @Override
    public Avatar saveAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    @Override
    public void deleteAvatar(Integer id) {
        avatarRepository.delete(id);
    }
}
