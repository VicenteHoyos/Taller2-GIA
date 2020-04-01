/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.dto;

import java.util.ArrayList;

/**
 *
 * @author NICOLAS
 */
public class Consecutivo {
    public static Long asignarId(ArrayList<UserDto> lista){
    
        if (lista.isEmpty()){
        return 1L;
        }
        else{
        Long id= lista.get(lista.size()-1).getId()+1;
        return id;
        }
    }
}
