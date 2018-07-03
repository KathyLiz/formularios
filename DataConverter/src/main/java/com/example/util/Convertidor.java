/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.example.entities.Formulario;
import com.example.entities.FormularioData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Kathy
 */
public class Convertidor {
    private FormularioData frmData = FormularioData.getInstancia();
    public Convertidor(){}
    
    public void convertirJson (String data){
        Gson gson = new Gson();
        System.out.println("DATA " + data);
        Formulario formulario = gson.fromJson(data, Formulario.class);
        this.frmData.setFacultad(formulario.getFacultad());
        this.frmData.setCarrera(formulario.getCarrera());
        this.frmData.setNombres(formulario.getNombres());
        this.frmData.setApellidos(formulario.getApellidos());
        this.frmData.setDocumento(formulario.getDocumento());
        this.frmData.setPeriodo(formulario.getPeriodo());
        this.frmData.setFecha(formulario.getFecha());
        this.frmData.setTipo(formulario.getTipo());
        System.out.println("Objeto data "+  new Gson().toJson(this.frmData));
       // return formulario;
    }
    
}
