package com.br.ifma.logeasy.services;


import com.br.ifma.logeasy.domain.Avatar;

public interface AvatarService {
    Iterable<Avatar> listAllAvatars();

    Avatar getAvatarById(Integer id);

    Avatar saveAvatar(Avatar avatar);

    void deleteAvatar(Integer id);
}
