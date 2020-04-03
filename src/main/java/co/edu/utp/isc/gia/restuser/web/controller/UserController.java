/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.restuser.service.UserService;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author NICOLAS
 */
@RestController
@RequestMapping("user")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    
    @PostMapping()
    public UserDto save(@RequestBody UserDto user){
        return userService.save(user); 
    }
    
    
    @GetMapping()
    public ResponseEntity<?> listAll(){
        List<UserDto> lista = userService.listAll();
        
        if(lista == null || lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(lista);
    }
    
     @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Long id){
        
        UserDto user = userService.findOne(id);
        
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        
        UserDto user = userService.findOne(id);
        
        if(user == null){
            return ResponseEntity.ok(false);
        }
        
        userService.delete(user.getId());
        return ResponseEntity.ok(true);
    }
    /*
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto user){
        
        UserDto consulta = userService.findOne(user.getId());
        
        if(consulta == null){
            return ResponseEntity.notFound().build();
        }
        consulta = userService.save(user);
        
        if(consulta == null){
            
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(consulta);
    }*/
    
}
