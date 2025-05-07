/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.umbra.ProjetoSistema.controller;

import br.dev.umbra.ProjetoSistema.entities.Food;
import br.dev.umbra.ProjetoSistema.service.FoodService;
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
import br.dev.umbra.ProjetoSistema.repositories.FoodRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Sam_Umbra
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "foods")
public class FoodController {
    
    @Autowired
    private FoodService foodService;
    
    @Autowired
    private FoodRepository foodRepository;
    
    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        List<Food> result = foodService.findAll();
        
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
    
    @GetMapping("/{foodID}")
    public ResponseEntity<Food> findById(@PathVariable Long foodID) {
        Optional<Food> result = foodService.findById(foodID);
        
        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result.get());
        }
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Food create(@RequestBody Food food) {
        return foodService.save(food);
    }
    
    @PutMapping("/{foodID}")
    public ResponseEntity<Food> update(@PathVariable Long foodID,
                                             @RequestBody Food food) {
        
        if(!foodRepository.existsById(foodID)) {
            return ResponseEntity.notFound().build();
        } else {
            food.setId(foodID);
            food = foodService.save(food);
            return ResponseEntity.ok(food);
        }
        
    }
    
    @DeleteMapping("/{foodID}")
    public ResponseEntity<Void> delete(@PathVariable Long foodID) {
        if(!foodRepository.existsById(foodID)) {
            return ResponseEntity.notFound().build();
        } else {
            foodService.delete(foodID);
            return ResponseEntity.noContent().build();
        }
    }
    
}
