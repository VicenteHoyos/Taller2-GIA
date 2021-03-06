/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.UserModel;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.Consecutivo;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author Vicente
 */

@Service
public class UserService {
    //private List<UserDto> users= new ArrayList();
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    
    public UserDto save(UserDto user){
        UserModel myUser = modelMapper.map(user, UserModel.class);
        myUser  = userRepository.save(myUser);
        UserDto resp = modelMapper.map(myUser, UserDto.class);

        return resp;
        //user.setId(Consecutivo.asignarId((ArrayList<UserDto>) users));
        //user.setUsername(user.getUsername().toLowerCase());
        //users.add(user);
        //return user;
    }
    
    public List<UserDto> listAll() {
        List<UserModel> lista = (List<UserModel>) userRepository.findAll();
        List<UserDto> respuesta = new ArrayList<>();
        
        if(lista == null || lista.isEmpty()){
            return null;
        }
        
        for(UserModel usuario : lista){
            respuesta.add(modelMapper.map(usuario, UserDto.class));
        }
        return respuesta;
    }
    
    public UserDto findOne(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        
        if(user.isPresent()){
            return modelMapper.map(user, UserDto.class);
        }
        
        return null;
    }
    
    public boolean delete(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        
        if(user == null){
            return false;
        }
        
        return true;
    }
    
   
}
