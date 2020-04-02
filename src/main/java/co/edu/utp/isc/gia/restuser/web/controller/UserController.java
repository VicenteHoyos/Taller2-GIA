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
    
    
   /* @GetMapping()
    public List<UserDto> getAll(){
        return userService.listAll();
    }
    
    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable("id") Long id){
        return userService.findOne(id);
    }
    
    @PutMapping("update/{id}")
    public UserDto updateOne(@PathVariable("id") Long id, @RequestBody UserDto user){
        return userService.editOne(id,user);
    }
    
    @DeleteMapping("delete/{id}")
    public UserDto removeOne(@PathVariable("id") Long id){
        return userService.removeOne(id);
    
    }*/
    
}
