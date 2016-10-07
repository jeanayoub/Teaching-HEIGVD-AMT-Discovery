/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.ch.amt.appmvc.model;

/**
 *
 * @author Ayoubo
 */
public class Fruit {
    
    private final String name;
    private final String color;
    
    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    
    
    
}
