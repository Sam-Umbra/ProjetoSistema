/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package br.dev.umbra.ProjetoSistema.domain.service;

import br.dev.umbra.ProjetoSistema.domain.model.Food;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.dev.umbra.ProjetoSistema.domain.repository.FoodRepository;
import java.util.Optional;

/**
 *
 * @author Sam_Umbra
 */
@Service
public class FoodService {
    
    @Autowired
    private FoodRepository foodRepository;
    
    public List<Food> findAll() {
        return foodRepository.findAll();
    }
    
    public Optional<Food> findById(Long foodID) {
        return foodRepository.findById(foodID);
    }
    
    public Food save(Food food) {
        // ID vazio --> Novo User
        // ID Preenchidp --> Alterar User
        return foodRepository.save(food);
    }
    
    public void delete(Long foodID) {
        // Verifica se existe e pega o User
        Food existingFood = foodRepository.findById(foodID).get();
        foodRepository.delete(existingFood);
    }
    
}
