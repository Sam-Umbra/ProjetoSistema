/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package br.dev.umbra.ProjetoSistema.domain.service;

import br.dev.umbra.ProjetoSistema.domain.model.UserEntity;
import br.dev.umbra.ProjetoSistema.domain.repository.UserEntityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sam_Umbra
 */
@Service
public class UserEntityService {
    
    @Autowired
    private UserEntityRepository userEntityRepository;
    
    public List<UserEntity> findAll() {
        return userEntityRepository.findAll();
    }
    
    public UserEntity findById(Long userID) {
        return userEntityRepository.findById(userID).get();
    }
    
    public UserEntity save(UserEntity user) {
        // ID vazio --> Novo User
        // ID Preenchidp --> Alterar User
        return userEntityRepository.save(user);
    }
    
    public void delete(Long userID) {
        // Verifica se existe e pega o User
        UserEntity existingUser = userEntityRepository.findById(userID).get();
        userEntityRepository.delete(existingUser);
    }
    
}
