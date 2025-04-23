/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.umbra.ProjetoSistema.api.controller;

import br.dev.umbra.ProjetoSistema.domain.model.UserEntity;
import br.dev.umbra.ProjetoSistema.domain.repository.UserEntityRepository;
import br.dev.umbra.ProjetoSistema.domain.service.UserEntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sam_Umbra
 */
@RestController
@RequestMapping(value = "/users")
public class UserEntityController {
    
    @Autowired
    private UserEntityService userEntityService;
    
    @Autowired
    private UserEntityRepository userEntityRepository;
    
    @GetMapping
    public List<UserEntity> findAll() {
        return userEntityService.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity insert(@RequestBody UserEntity user) {
        return userEntityService.save(user);
    }
    
    @PutMapping("/{userID}")
    public ResponseEntity<UserEntity> update(@PathVariable Long userID,
                                             @RequestBody UserEntity user) {
        
        if(!userEntityRepository.existsById(userID)) {
            return ResponseEntity.notFound().build();
        } else {
            user.setId(userID);
            user = userEntityService.save(user);
            return ResponseEntity.ok(user);
        }
        
    }
    
    @DeleteMapping("/{userID}")
    public ResponseEntity<Void> delete(@PathVariable Long userID) {
        if(!userEntityRepository.existsById(userID)) {
            return ResponseEntity.notFound().build();
        } else {
            userEntityService.delete(userID);
            return ResponseEntity.noContent().build();
        }
    }
    
}
