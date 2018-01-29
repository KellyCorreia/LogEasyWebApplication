package com.br.ifma.logeasy.services;

import com.br.ifma.logeasy.domain.User;

public interface UserService extends CRUDService<User> {

    User findByUsername(String username);
    User criptografaSenha(User usuario);

}
