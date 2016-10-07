/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.ch.amt.appmvc.services;
import ch.heigvd.ch.amt.appmvc.model.Fruit;

/**
 *
 * @author Ayoubo
 */
public class FruitsManager {
    
    public Fruit getRandomFruit() {
        return new Fruit("bannana", "yellow");
    }
    
}
