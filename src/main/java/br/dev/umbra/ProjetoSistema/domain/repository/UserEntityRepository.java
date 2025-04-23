/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package br.dev.umbra.ProjetoSistema.domain.repository;

import br.dev.umbra.ProjetoSistema.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sam_Umbra
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    
}
