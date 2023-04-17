/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.calificaciones.presentation.calificacion;

import com.progra.calificaciones.logic.Calificacion;
import com.progra.calificaciones.logic.Hotel;

/**
 *
 * @author ESCINF
 */
public class Model {
    Hotel current;
    Calificacion calificacion;
    
        public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Hotel());
        setCalificacion(new Calificacion());
    }
    
    public Hotel getCurrent() {
        return current;
    }

    public void setCurrent(Hotel current) {
        this.current = current;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
}
