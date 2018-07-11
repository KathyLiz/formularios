/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 *
 * @author Kathy
 */
public class Formulario {
    private String tipo;
    private String nombre;
    private String facultad;
    private String carrera;
    private String nombres;
    private String apellidos;
    private String documento;
    private String periodo;
    private String fecha;
    private String justificacion;
    private String adjuntos;
  /*  private static Formulario formulario;
    
   public  static Formulario getInstancia(String facultad, String carrera, String nombres, String apellidos, String documento, String periodo, String fecha) {
 
    if (formulario==null) {

    formulario = new Formulario(facultad, carrera, nombres, apellidos, documento, periodo, fecha);
    }
    return formulario;
    }*/

    private Formulario(String facultad, String carrera, String nombres, String apellidos, String documento, String periodo, String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // GETTERS

    public String getFacultad() {
        return facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getFecha() {
        return fecha;
    }

    /*public static Formulario getFormulario() {
        return formulario;
    }*/
    
    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(String adjuntos) {
        this.adjuntos = adjuntos;
    }
    
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
