package com.equipo.controller;
import com.equipo.model.Autor;
import java.io.IOException;
import java.net.URISyntaxException;


public class ControladorAutor {
    private Autor autor;

    public ControladorAutor(Autor autor) {
        this.autor = autor;
    }

    public String performSearch() throws URISyntaxException, IOException, InterruptedException {
        return autor.performSearch();
    }
}
