/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package br.dev.umbra.ProjetoSistema.repositories;

import br.dev.umbra.ProjetoSistema.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sam_Umbra
 */
public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
