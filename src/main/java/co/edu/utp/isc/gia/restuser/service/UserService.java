/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.web.dto.Consecutivo;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vicente
 */

@Service
public class UserService {
    private List<UserDto> users= new ArrayList();
    
    
    public UserDto save(UserDto user){
        user.setId(Consecutivo.asignarId((ArrayList<UserDto>) users));
        user.setUsername(user.getUsername().toLowerCase());
        users.add(user);
        return user;
    }
    
    public List<UserDto> listAll(){
        return users;
    }
    
    public UserDto findOne(Long id){
        for(UserDto u: users){
            if(u.getId().equals(id)){
                return u;
            }   
        }
        return null;
     }
    
    public UserDto editOne(Long id, UserDto user){
        
        UserDto usuario =findOne(id);
        
            if (usuario==null){
                return null;
            }else{
            user.setId(id);
            users.set(users.indexOf(usuario), user);
            return findOne(id);
                }
               
    }
    
    public UserDto removeOne(Long id){
    
        UserDto usuario=findOne(id);
        if (usuario==null){
                return null;
            }else{
            
            users.remove(users.indexOf(usuario));
            return usuario;
                }
        
    }
    
    
}
