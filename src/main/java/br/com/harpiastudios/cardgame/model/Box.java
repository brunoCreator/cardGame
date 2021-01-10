/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

/**
 *
 * @author rotch
 */
public class Box{
    private int key;
    private String value; 

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Box(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
      return value ;
   }
}
