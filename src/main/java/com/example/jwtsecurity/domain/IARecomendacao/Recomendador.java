package com.example.jwtsecurity.domain.IARecomendacao;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;

public class Recomendador {

    public DataModel getModeloEventos() throws IOException {
        //arquivo usado com a base de usuários, os códigos dos eventos e as notas atribuídas
        return getModelo("eventos.csv");
    }

    private DataModel getModelo(String path) throws IOException {
        File file = new File("src/main/resources/" + path);
        return new FileDataModel(file);
    }
}
