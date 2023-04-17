/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.calificaciones.presentation.hoteles;

import com.progra.calificaciones.logic.Hotel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESCINF
 */
public class Model {

    List<Hotel> hoteles;

    public Model() {
        this.reset();
    }

    public void reset() {
        setHoteles(new ArrayList<>());
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

}
