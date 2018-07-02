/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.example.entities.Formulario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Kathy
 */
public class Convertidor {
    
    public Convertidor(){}
    
    public Formulario convertirJson (String data){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Formulario formulario = gson.fromJson(data, Formulario.class);
        return formulario;
    }
    
}
