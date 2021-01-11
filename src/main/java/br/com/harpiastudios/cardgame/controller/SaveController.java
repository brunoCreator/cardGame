/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.controller;

import br.com.harpiastudios.cardgame.model.Storage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 *
 * @author Diego
 */
public class SaveController {

    private File file;

    public SaveController() {
        try {
            file = new File("./data.json");
            if (file.createNewFile()) {
                System.out.println("Arquivo criado com successo.");
            } else {
                System.out.println("Carregando todos os dados cadastrados anteriormente..");
            }
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao criar o arquivo para salvar os registros...");
            e.printStackTrace();
        }
    }

    public Storage Load() {
        Storage storage;
        try {
            String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            System.out.println(json);
            TypeToken<Storage> token = new TypeToken<Storage>() {
            };
            storage = new Gson().fromJson(json, token.getType());
            if (storage != null) {
                System.out.println("Foram carregados " + storage.getDecks().size() + " de decks..");
                System.out.println("Foram carregados " + storage.getCards().size() + " cartas..");
            } else {
                storage = new Storage();
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o estoque: " + e.getMessage());
            storage = new Storage();
        }
        return storage;
    }

    public void Save(Storage storage) {
        String output = new Gson().toJson(storage);
        System.out.println(output);
        try {
            FileWriter file = new FileWriter("./data.json", StandardCharsets.UTF_8);
            file.write(output);
            file.close();
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao criar o arquivo para salvar os registros...");
            e.printStackTrace();
        }
    }
}
