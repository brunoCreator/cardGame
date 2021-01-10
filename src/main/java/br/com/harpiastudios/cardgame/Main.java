/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame;

import br.com.harpiastudios.cardgame.view.LoginView;
import br.com.harpiastudios.cardgame.view.MenuView;

/**
 *
 * @author Diego
 */
public class Main {
    public static void main(String[] args){
        MenuView view = new MenuView();
        view.setVisible(true);
    }
}
